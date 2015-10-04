package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import android.view.View.OnClickListener;

public class FivePlayer extends Activity implements OnClickListener {
    private static final String PLAYERONEFILENAME   = "PlayerOneInFivePlayer.sav";
    private static final String PLAYERTWOFILENAME   = "PlayerTwoInFivePlayer.sav";
    private static final String PLAYERTHREEFILENAME = "PlayerThreeInFivePlayer.sav";
    private static final String PLAYERFOURFILENAME  = "PlayerFourInFivePlayer.sav";
    private static final String PLAYERFIVEFILENAME  = "PlayerFiveInFivePlayer.sav";

    private ArrayList<PlayerOne>  playerOneListInFiveplayer   = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo>  playerTwoListInFiveplayer   = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerThree>playerThreeListInFiveplayer = new ArrayList<PlayerThree>();
    private ArrayList<PlayerFour> playerFourListInFiveplayer  = new ArrayList<PlayerFour>();
    private ArrayList<PlayerFive> playerFiveListInFiveplayer  = new ArrayList<PlayerFive>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_player_activity);
        Button playerOne = (Button) findViewById(R.id.b_playerone_in_fiveplayer);
        Button playerTwo = (Button) findViewById(R.id.b_playertwo_in_fiveplayer);
        Button playerThree = (Button) findViewById(R.id.b_playerthree_in_fiveplayer);
        Button playerFour = (Button) findViewById(R.id.b_playerfour_in_fiveplayer);
        Button playerFive = (Button) findViewById(R.id.b_playerfive_in_fiveplayer);

        playerOne.setOnClickListener(this);
        playerTwo.setOnClickListener(this);
        playerThree.setOnClickListener(this);
        playerFour.setOnClickListener(this);
        playerFive.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(PLAYERONEFILENAME);
        loadFromFile(PLAYERTWOFILENAME);
        loadFromFile(PLAYERTHREEFILENAME);
        loadFromFile(PLAYERFOURFILENAME);
        loadFromFile(PLAYERFIVEFILENAME);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_playerone_in_fiveplayer){
            int count;
            try{
                count =  playerOneListInFiveplayer.get(playerOneListInFiveplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerOne Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerOneListInFiveplayer.add(new PlayerOne(count));
            saveInFile(PLAYERONEFILENAME, playerOneListInFiveplayer);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_playertwo_in_fiveplayer) {
            int count;
            try{
                count =  playerTwoListInFiveplayer.get(playerTwoListInFiveplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerTwoListInFiveplayer.add(new PlayerTwo(count));
            saveInFile(PLAYERTWOFILENAME, playerTwoListInFiveplayer);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_playerthree_in_fiveplayer) {
            int count;
            try{
                count =  playerThreeListInFiveplayer.get(playerThreeListInFiveplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerThreeListInFiveplayer.add(new PlayerThree(count));
            saveInFile(PLAYERTHREEFILENAME, playerThreeListInFiveplayer);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_playerfour_in_fiveplayer) {
            int count;
            try{
                count =  playerFourListInFiveplayer.get(playerFourListInFiveplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerFourListInFiveplayer.add(new PlayerFour(count));
            saveInFile(PLAYERFOURFILENAME, playerFourListInFiveplayer);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_playerfive_in_fiveplayer) {
            int count;
            try{
                count =  playerFiveListInFiveplayer.get(playerFiveListInFiveplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerFiveListInFiveplayer.add(new PlayerFive(count));
            saveInFile(PLAYERFIVEFILENAME, playerFiveListInFiveplayer);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();
            //classIntent(ResultPage.class);
        }
    }
    /**
     * simple method switch activity
     * @param newClass
     **/
    public void classIntent(Class newClass){
        Intent openNewActivity = new Intent(getApplicationContext(), newClass);
        startActivity(openNewActivity);
    }
    private void saveInFile(String FileName, ArrayList playerList) {
        try {
            FileOutputStream fos = openFileOutput(FileName, 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson  =new Gson();
            gson.toJson(playerList, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
    private void loadFromFile(String fileName) {

        if(fileName.equals(PLAYERONEFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));


                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerOne>>(){}.getType();
                playerOneListInFiveplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerOneListInFiveplayer = new ArrayList<PlayerOne>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(fileName.equals(PLAYERTWOFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));

                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerTwo>>(){}.getType();
                playerTwoListInFiveplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerTwoListInFiveplayer = new ArrayList<PlayerTwo>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(fileName.equals(PLAYERTHREEFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));


                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerThree>>(){}.getType();
                playerThreeListInFiveplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerThreeListInFiveplayer = new ArrayList<PlayerThree>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(fileName.equals(PLAYERFOURFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));


                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerFour>>(){}.getType();
                playerFourListInFiveplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerFourListInFiveplayer = new ArrayList<PlayerFour>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(fileName.equals(PLAYERFIVEFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));


                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerFive>>(){}.getType();
                playerFiveListInFiveplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerFiveListInFiveplayer = new ArrayList<PlayerFive>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}

package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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

public class ThreePlayer extends Activity implements OnClickListener {
    private static final String PLAYERONEFILENAME   = "PlayerOneInThreePlayer.sav";
    private static final String PLAYERTWOFILENAME   = "PlayerTwoInThreePlayer.sav";
    private static final String PLAYERTHREEFILENAME = "PlayerThreeInThreePlayer.sav";

    private ArrayList<PlayerOne>  playerOneListInThreeplayer   = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo>  playerTwoListInThreeplayer   = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerThree>playerThreeListInThreeplayer = new ArrayList<PlayerThree>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_player_activity);
        Button playerOne = (Button) findViewById(R.id.b_player_one_in_threeplayer);
        Button playerTwo = (Button) findViewById(R.id.b_player_two_in_threeplayer);
        Button playerThree = (Button) findViewById(R.id.b_player_three_in_threeplayer);
        playerOne.setOnClickListener(this);
        playerTwo.setOnClickListener(this);
        playerThree.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(PLAYERONEFILENAME);
        loadFromFile(PLAYERTWOFILENAME);
        loadFromFile(PLAYERTHREEFILENAME);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_threeplayer){
            int count;
            try{
                count =  playerOneListInThreeplayer.get(playerOneListInThreeplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerOne Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerOneListInThreeplayer.add(new PlayerOne(count));
            saveInFile(PLAYERONEFILENAME, playerOneListInThreeplayer);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_two_in_threeplayer) {
            int count;
            try{
                count =  playerTwoListInThreeplayer.get(playerTwoListInThreeplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerTwoListInThreeplayer.add(new PlayerTwo(count));
            saveInFile(PLAYERTWOFILENAME, playerTwoListInThreeplayer);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_three_in_threeplayer) {
            int count;
            try{
                count =  playerThreeListInThreeplayer.get(playerThreeListInThreeplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerThreeListInThreeplayer.add(new PlayerThree(count));
            saveInFile(PLAYERTHREEFILENAME, playerThreeListInThreeplayer);
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
/**
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

**/
    }
}

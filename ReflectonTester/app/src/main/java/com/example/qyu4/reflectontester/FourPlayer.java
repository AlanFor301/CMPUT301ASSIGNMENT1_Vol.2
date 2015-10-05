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
/**
 * this project is for CMPUT301 assignment 1.
 * It's a free to use in any ways.
 * load and save file method is cited from Joshua2ua https://github.com/joshua2ua/lonelyTwitter
 * http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
 * Starting a system time point for single player
 */
public class FourPlayer extends Activity implements OnClickListener {
    private static final String PLAYERONEFILENAME   = "PlayerOneInFourPlayer.sav";
    private static final String PLAYERTWOFILENAME   = "PlayerTwoInFourPlayer.sav";
    private static final String PLAYERTHREEFILENAME = "PlayerThreeInFourPlayer.sav";
    private static final String PLAYERFOURFILENAME  = "PlayerFourInFourPlayer.sav";


    private ArrayList<PlayerOne> playerOneListInFourplayer   = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo>  playerTwoListInFourplayer   = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerThree>playerThreeListInFourplayer = new ArrayList<PlayerThree>();
    private ArrayList<PlayerFour> playerFourListInFourplayer  = new ArrayList<PlayerFour>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_player_activity);
        Button playerOne = (Button) findViewById(R.id.b_player_one_in_fourplayer);
        Button playerTwo = (Button) findViewById(R.id.b_player_two_in_fourplayer);
        Button playerThree = (Button) findViewById(R.id.b_player_three_in_fourplayer);
        Button playerFour = (Button) findViewById(R.id.b_player_four_in_fourplayer);
        playerOne.setOnClickListener(this);
        playerTwo.setOnClickListener(this);
        playerThree.setOnClickListener(this);
        playerFour.setOnClickListener(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(PLAYERONEFILENAME);
        loadFromFile(PLAYERTWOFILENAME);
        loadFromFile(PLAYERTHREEFILENAME);
        loadFromFile(PLAYERFOURFILENAME);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_fourplayer){
            int count;
            try{
                count =  playerOneListInFourplayer.get(playerOneListInFourplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerOne Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerOneListInFourplayer.add(new PlayerOne(count));
            saveInFile(PLAYERONEFILENAME, playerOneListInFourplayer);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_two_in_fourplayer) {
            int count;
            try{
                count =  playerTwoListInFourplayer.get(playerTwoListInFourplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerTwoListInFourplayer.add(new PlayerTwo(count));
            saveInFile(PLAYERTWOFILENAME, playerTwoListInFourplayer);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_three_in_fourplayer){
            int count;
            try{
                count =  playerThreeListInFourplayer.get(playerThreeListInFourplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerThree Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerThreeListInFourplayer.add(new PlayerThree(count));
            saveInFile(PLAYERTHREEFILENAME, playerOneListInFourplayer);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_four_in_fourplayer){
            int count;
            try{
                count =  playerFourListInFourplayer.get(playerFourListInFourplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerFour Count is: " + String.valueOf(count),
                    Toast.LENGTH_SHORT).show();

            playerFourListInFourplayer.add(new PlayerFour(count));
            saveInFile(PLAYERFOURFILENAME, playerFourListInFourplayer);
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
                playerOneListInFourplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerOneListInFourplayer = new ArrayList<PlayerOne>();
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
                playerTwoListInFourplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerTwoListInFourplayer = new ArrayList<PlayerTwo>();
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
                playerThreeListInFourplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerThreeListInFourplayer = new ArrayList<PlayerThree>();
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
                playerFourListInFourplayer = gson.fromJson(in, arrayListType);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerFourListInFourplayer = new ArrayList<PlayerFour>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



    }
}

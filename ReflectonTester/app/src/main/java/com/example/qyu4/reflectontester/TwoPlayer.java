package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
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

public class TwoPlayer extends Activity implements OnClickListener {
    private static final String PLAYERONEFILENAME = "PlayerOneInTwoPlayer.sav";
    private static final String PLAYERTWOFILENAME = "PlayerTwoInTwoPlayer.sav";

    private ArrayList<PlayerOne>playerOneListInTwoplayer = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo>playerTwoListInTwoplayer = new ArrayList<PlayerTwo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_player_activity);
        Button playerOne = (Button) findViewById(R.id.b_player_one_in_twoplayer);
        Button playerTwo = (Button) findViewById(R.id.b_player_two_in_twoplayer);
        playerOne.setOnClickListener(this);
        playerTwo.setOnClickListener(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(PLAYERONEFILENAME);
        loadFromFile(PLAYERTWOFILENAME);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_twoplayer){
            int count;
            try{
                count =  playerOneListInTwoplayer.get(playerOneListInTwoplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            Toast.makeText(getApplicationContext(), "PlayerOne Count is: "+String.valueOf(count), Toast.LENGTH_SHORT).show();

            playerOneListInTwoplayer.add(new PlayerOne(count));
            saveInFile(PLAYERONEFILENAME);
            //classIntent(ResultPage.class);
        }
        else if(view.getId()==R.    id.b_player_two_in_twoplayer) {
            int count;
            try{
                count =  playerTwoListInTwoplayer.get(playerTwoListInTwoplayer.size()-1).getBuzzCount()+1;
            }catch (Exception e){
                count = 1;
            }
            playerTwoListInTwoplayer.add(new PlayerTwo(count));
            saveInFile(PLAYERTWOFILENAME);
            Toast.makeText(getApplicationContext(), "PlayerTwo Count is: " + String.valueOf(count), Toast.LENGTH_SHORT).show();
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
    private void saveInFile(String FileName) {
        if(FileName.equals(PLAYERONEFILENAME)){
            try {
                FileOutputStream fos = openFileOutput(FileName, 0);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
                Gson gson  =new Gson();
                gson.toJson(playerOneListInTwoplayer, out);
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
        else if(FileName.equals(PLAYERTWOFILENAME)){
            try {
                FileOutputStream fos = openFileOutput(FileName, 0);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
                Gson gson  =new Gson();
                gson.toJson(playerTwoListInTwoplayer, out);
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

    }
    private void loadFromFile(String fileName) {
        if(fileName.equals(PLAYERONEFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));

                //******************************************//
                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerOne>>(){}.getType();
                playerOneListInTwoplayer = gson.fromJson(in, arrayListType);
                //******************************************//

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerOneListInTwoplayer = new ArrayList<PlayerOne>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(fileName.equals(PLAYERTWOFILENAME)){
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));

                //******************************************//
                Gson gson = new Gson();
                // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                Type arrayListType = new TypeToken<ArrayList<PlayerTwo>>(){}.getType();
                playerTwoListInTwoplayer = gson.fromJson(in, arrayListType);
                //******************************************//

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerTwoListInTwoplayer = new ArrayList<PlayerTwo>();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

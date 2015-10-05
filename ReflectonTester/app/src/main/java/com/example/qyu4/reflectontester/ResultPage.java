package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

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
public class ResultPage extends Activity {
    private static final String SINGLEPLAYERFILENAME = "singlePlayer.sav";
    private static final String PLAYERONEINTWOPALYERFILENAME     = "PlayerOneInTwoPlayer.sav";
    private static final String PLAYERTWOINTWOPALYERFILENAME     = "PlayerTwoInTwoPlayer.sav";
    private static final String PLAYERONEINTHREEPALYERFILENAME   = "PlayerOneInThreePlayer.sav";
    private static final String PLAYERTWOINTHREEPALYERFILENAME   = "PlayerTwoInThreePlayer.sav";
    private static final String PLAYERTHREEINTHREEPALYERFILENAME = "PlayerThreeInThreePlayer.sav";
    private static final String PLAYERONEINFOURPALYERFILENAME    = "PlayerOneInFourPlayer.sav";
    private static final String PLAYERTWOINFOURPALYERFILENAME    = "PlayerTwoInFourPlayer.sav";
    private static final String PLAYERTHREEINFOURPALYERFILENAME  = "PlayerThreeInFourPlayer.sav";
    private static final String PLAYERFOURINFOURPALYERFILENAME   = "PlayerFourInFourPlayer.sav";

    private ArrayList<SinglePlayer> singlePlayerStat = new ArrayList<SinglePlayer>();
    private ArrayList<PlayerOne> playerOneInTwo = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo> playerTwoInTwo = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerOne> playerOneInThree = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo> playerTwoInThree = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerThree> playerThreeInThree = new ArrayList<PlayerThree>();
    private ArrayList<PlayerOne> playerOneInFour = new ArrayList<PlayerOne>();
    private ArrayList<PlayerTwo> playerTwoInFour = new ArrayList<PlayerTwo>();
    private ArrayList<PlayerThree> playerThreeInFour = new ArrayList<PlayerThree>();
    private ArrayList<PlayerFour> playerFourInFour = new ArrayList<PlayerFour>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page_activity);
        TextView tvLastTenMax = (TextView) findViewById(R.id.tv_last_ten_max);
        TextView tvLastOneHundredMax = (TextView) findViewById(R.id.tv_last_one_hundred_max);
        TextView tvAllMax = (TextView) findViewById(R.id.tv_all_max);
        TextView tvLastTenMin = (TextView) findViewById(R.id.tv_last_ten_min);
        TextView tvLastOneHundredMin = (TextView) findViewById(R.id.tv_last_one_hundred_min);
        TextView tvAllMin = (TextView) findViewById(R.id.tv_all_min);
        TextView tvTenMedian = (TextView) findViewById(R.id.tv_last_ten_median);
        TextView tvOneHundredMedian = (TextView) findViewById(R.id.tv_last_one_hundred_median);
        TextView tvAllMedian = (TextView) findViewById(R.id.tv_all_median);
        TextView tvTenaverage = (TextView) findViewById(R.id.tv_ten_average);
        TextView tvOneHundredAverage = (TextView) findViewById(R.id.tv_average_one_hundred);
        TextView tvAllAverage = (TextView) findViewById(R.id.tv_average_all);
        TextView tvPlayerOneInTwo = (TextView) findViewById(R.id.player_one_in_twoplayer);
        TextView tvPlayerTwoInTwo = (TextView) findViewById(R.id.player_two_in_twoplayer);

        TextView tvPlayerOneInThree = (TextView) findViewById(R.id.player_one_in_threeplayer);
        TextView tvPlayerTwoInThree = (TextView) findViewById(R.id.player_two_in_threeplayer);
        TextView tvPlayerThreeInThree = (TextView) findViewById(R.id.b_player_three_in_threeplayer);

        TextView tvPlayerOneInFour = (TextView) findViewById(R.id.b_player_one_in_fourplayer);
        TextView tvPlayerTwoInFour = (TextView) findViewById(R.id.b_player_two_in_fourplayer);
        TextView tvPlayerThreeInFour = (TextView) findViewById(R.id.b_player_three_in_fourplayer);
        TextView tvPlayerFourInFour = (TextView) findViewById(R.id.b_player_four_in_fourplayer);

        getSinglePlayerStat(tvLastTenMax, tvLastOneHundredMax, tvAllMax, tvLastTenMin, tvLastOneHundredMin,
                tvAllMin, tvTenMedian, tvOneHundredMedian, tvAllMedian, tvTenaverage, tvOneHundredAverage, tvAllAverage);
        getPlayerOneInTwo(tvPlayerOneInTwo);
        getPlayerTwoInTwo(tvPlayerTwoInTwo);
        getPlayerOneInThree(tvPlayerOneInThree);
        getPlayerTwoInThree(tvPlayerTwoInThree);
        //getPlayerThreeInThree(tvPlayerThreeInThree);
        //getPlayerOneInFour(tvPlayerOneInFour);
        //getPlayerTwoInFour(tvPlayerTwoInFour);
        //getPlayerThreeInFour(tvPlayerThreeInFour);
        //getPlayerFourInFour(tvPlayerFourInFour);

    }
    private void getSinglePlayerStat(TextView tvLastTenMax, TextView tvLastOneHundredMax, TextView tvAllMax,
                                     TextView tvLastTenMin, TextView tvLastOneHundredMin, TextView tvAllMin,
                                     TextView tvTenMedian, TextView tvOneHundredMedian, TextView tvAllMedian,
                                     TextView tvTenaverage, TextView tvOneHundredAverage, TextView tvAllAverage){
        loadFromFile();
        TimeManage tm = new TimeManage(singlePlayerStat);


        tvLastTenMax.setText(String.valueOf(tm.getMaxTen()));
        tvLastOneHundredMax.setText(String.valueOf(tm.getMaxOneHundred()));
        tvAllMax.setText(String.valueOf(tm.getMaxAll()));
        tvLastTenMin.setText(String.valueOf(tm.getMinTen()));
        tvLastOneHundredMin.setText(String.valueOf(tm.getMinOneHundred()));
        tvAllMin.setText(String.valueOf(tm.getMinAll()));
        tvTenMedian.setText(String.valueOf(tm.getMedianTen()));
        tvOneHundredMedian.setText(String.valueOf(tm.getMedianOnehundred()));
        tvAllMedian.setText(String.valueOf(tm.getMedianAll()));
        tvTenaverage.setText(String.valueOf(tm.getAverageTen()));
        tvOneHundredAverage.setText(String.valueOf(tm.getAverageOneHundred()));
        tvAllAverage.setText(String.valueOf(tm.getAverageAll()));
    }
    private void getPlayerOneInTwo(TextView tvPlayerOneInTwo){
        int count;
        loadForPlayerOneInTwoPlayer();
        try{
            count =playerOneInTwo.get(playerOneInTwo.size()-1).getBuzzCount();
        }catch(Exception e){
            count =0;
        }

        tvPlayerOneInTwo.setText(String.valueOf(count));
    }
    private void getPlayerTwoInTwo(TextView tvPlayerTwoInTwo){
        int count;
        loadForPlayerTwoInTwoPlayer();
        try{
            count =playerTwoInTwo.get(playerTwoInTwo.size()-1).getBuzzCount();
        }catch(Exception e){
            count =0;
        }
        tvPlayerTwoInTwo.setText(String.valueOf(count));
    }
    private void getPlayerOneInThree(TextView tvPlayerOneInThree){

        loadForPlayerTwoInTwoPlayer();
        int count;
        try{
            count =playerOneInThree.get(playerOneInThree.size()-1).getBuzzCount();
        }catch(Exception e){
            count =0;
        }

        tvPlayerOneInThree.setText(String.valueOf(count));
    }
    private void getPlayerTwoInThree(TextView tvPlayerTwoInThree){
        loadForPlayerTwoInThreePlayer();
        int count;
        try{
            count =playerTwoInThree.get(playerTwoInThree.size()-1).getBuzzCount();
        }catch(Exception e){
            count =0;
        }

        tvPlayerTwoInThree.setText(String.valueOf(count));
    }
    private void getPlayerThreeInThree(TextView tvPlayerThreeInThree){
        loadForPlayerThreeInThreePlayer();

        int count =playerThreeInThree.get(playerThreeInThree.size()-1).getBuzzCount();
        tvPlayerThreeInThree.setText(String.valueOf(count));
    }
    private void getPlayerOneInFour(TextView tvPlayerOneInFour){
        loadForPlayerInFourPlayer(PLAYERONEINFOURPALYERFILENAME);

        int count =playerOneInFour.get(playerOneInFour.size()-1).getBuzzCount();
        tvPlayerOneInFour.setText(String.valueOf(count));
    }
    private void getPlayerTwoInFour(TextView tvPlayerTwoInFour){
        loadForPlayerInFourPlayer(PLAYERTWOINFOURPALYERFILENAME);

        int count =playerTwoInFour.get(playerTwoInFour.size()-1).getBuzzCount();
        tvPlayerTwoInFour.setText(String.valueOf(count));
    }
    private void getPlayerThreeInFour(TextView tvPlayerThreeInFour){
        loadForPlayerInFourPlayer(PLAYERTHREEINFOURPALYERFILENAME);

        int count =playerThreeInFour.get(playerThreeInFour.size()-1).getBuzzCount();
        tvPlayerThreeInFour.setText(String.valueOf(count));
    }
    private void getPlayerFourInFour(TextView tvPlayerFourInFour){
        loadForPlayerInFourPlayer(PLAYERFOURINFOURPALYERFILENAME);

        int count =playerFourInFour.get(playerFourInFour.size()-1).getBuzzCount();
        tvPlayerFourInFour.setText(String.valueOf(count));
    }
    private void loadForPlayerOneInThreePlayer() {
        try {
            FileInputStream fis = openFileInput(PLAYERONEINTHREEPALYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<PlayerOne>>() {
            }.getType();
            playerOneInThree = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            playerOneInThree = new ArrayList<PlayerOne>();
        }
    }
    private void loadForPlayerTwoInThreePlayer() {
        try {
            FileInputStream fis = openFileInput(PLAYERTWOINTHREEPALYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<PlayerTwo>>() {
            }.getType();
            playerTwoInThree = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            playerTwoInThree = new ArrayList<PlayerTwo>();
        }
    }
    private void loadForPlayerThreeInThreePlayer() {
        try {
            FileInputStream fis = openFileInput(PLAYERTHREEINTHREEPALYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            /**
             *https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
             */

            Type arrayListType = new TypeToken<ArrayList<PlayerThree>>() {
            }.getType();
            playerThreeInThree = gson.fromJson(in, arrayListType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            playerThreeInThree = new ArrayList<PlayerThree>();
        }
    }
    private void loadForPlayerOneInTwoPlayer() {
        try {
            FileInputStream fis = openFileInput(PLAYERONEINTWOPALYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<PlayerOne>>() {
            }.getType();
            playerOneInTwo = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            playerOneInTwo = new ArrayList<PlayerOne>();
        }
    }
    private void loadForPlayerTwoInTwoPlayer() {
        try {
            FileInputStream fis = openFileInput(PLAYERTWOINTWOPALYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<PlayerTwo>>() {
            }.getType();
            playerTwoInTwo = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            playerTwoInTwo = new ArrayList<PlayerTwo>();
        }
    }
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(SINGLEPLAYERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<SinglePlayer>>(){}.getType();
            singlePlayerStat = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            singlePlayerStat = new ArrayList<SinglePlayer>();
        }
    }
    private void loadForPlayerInFourPlayer(String fileName) {
        if(fileName.equals(PLAYERONEINFOURPALYERFILENAME)){
            try {
                FileInputStream fis = openFileInput(PLAYERONEINFOURPALYERFILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                Gson gson = new Gson();
                /**
                 *https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                 */

                Type arrayListType = new TypeToken<ArrayList<PlayerOne>>() {
                }.getType();
                playerOneInFour = gson.fromJson(in, arrayListType);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerOneInFour = new ArrayList<PlayerOne>();
            }
        } else if(fileName.equals(PLAYERTWOINFOURPALYERFILENAME)){
            try {
                FileInputStream fis = openFileInput(PLAYERTWOINFOURPALYERFILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                Gson gson = new Gson();
                /**
                 *https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                 */

                Type arrayListType = new TypeToken<ArrayList<PlayerTwo>>() {
                }.getType();
                playerTwoInFour = gson.fromJson(in, arrayListType);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerTwoInFour = new ArrayList<PlayerTwo>();
            }
        }else if(fileName.equals(PLAYERTHREEINFOURPALYERFILENAME)){
            try {
                FileInputStream fis = openFileInput(PLAYERTHREEINFOURPALYERFILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                Gson gson = new Gson();
                /**
                 *https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                 */

                Type arrayListType = new TypeToken<ArrayList<PlayerThree>>() {
                }.getType();
                playerThreeInFour = gson.fromJson(in, arrayListType);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerThreeInFour = new ArrayList<PlayerThree>();
            }
        }else if(fileName.equals(PLAYERFOURINFOURPALYERFILENAME)){
            try {
                FileInputStream fis = openFileInput(PLAYERFOURINFOURPALYERFILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                Gson gson = new Gson();
                /**
                 *https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
                 */

                Type arrayListType = new TypeToken<ArrayList<PlayerThree>>() {
                }.getType();
                playerFourInFour = gson.fromJson(in, arrayListType);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                playerFourInFour = new ArrayList<PlayerFour>();
            }
        }

    }


}

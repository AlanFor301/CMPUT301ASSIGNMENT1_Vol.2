package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import android.view.View.OnClickListener;

public class SignlePlayerReadyCheck extends Activity implements OnClickListener{
    private int randTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signle_player_ready_check_activity);
        /**********************************************************************************/
        final Button singleReadyButton = (Button) findViewById(R.id.b_single_player_ready);
        singleReadyButton.setOnClickListener(this);
        /**********************************************************************************/
    }
    /**
     * Alan Sep 27,2015. Creg Case. http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * The Method override the super Onclick listener,
     * since we might have multiple button in the future
     * @param view
     **/
    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.b_single_player_ready) {
            randTime = randInt(10, 2000);
            handleRandomTime(randTime);
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

    /**
     * the method will wait for a random give milli-second period
     * then switch to a new class.
     * @param randTime
     **/
    public void handleRandomTime(int randTime){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            classIntent(SinglePlayerReflectionActivity.class);
            }
        }, randTime);
    }

}

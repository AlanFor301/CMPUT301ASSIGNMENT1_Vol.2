package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * this project is for CMPUT301 assignment 1.
 * It's a free to use in any ways.
 * load and save file method is cited from Joshua2ua https://github.com/joshua2ua/lonelyTwitter
 * http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
 * Starting a system time point for single player
 */

public class PlayerTypeActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_type_activity);
        /**
         * set up button.
         */
        Button singlePlayerMode = (Button) findViewById(R.id.b_single_player);
        Button multiPlayerMode  = (Button) findViewById(R.id.b_multi_player);
        Button bStat = (Button)findViewById(R.id.b_stat);
        Button bClear = (Button)findViewById(R.id.b_clear);

        /**
         * set up listener.
         */
        singlePlayerMode.setOnClickListener(this);
        multiPlayerMode.setOnClickListener(this);
        bStat.setOnClickListener(this);
        bClear.setOnClickListener(this);
    }



    /**
     * The Method override the super Onclick listener,
     * since we might have multiple button in the future
     * @param view
     */
    @Override
    public void onClick(View view) {
        //Todo intent to multi player page
        if(view.getId()==R.id.b_single_player) {
            classIntent(SignlePlayerReadyCheck.class);
        }
        //Todo intent to multi player page
        else if(view.getId()==R.id.b_multi_player){
            classIntent(MultiPlayerActivity.class);
        }
        else if(view.getId()==R.id.b_stat){
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_clear){

        }
    }

    /**
     * simple method switch activity
     * @param newClass
     */
    public void classIntent(Class newClass){
        Intent openNewActivity = new Intent(getApplicationContext(), newClass);
        startActivity(openNewActivity);
    }
}

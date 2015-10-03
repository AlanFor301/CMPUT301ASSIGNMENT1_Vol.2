package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 *Player type choose activity.
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
        /**
         * set up listener.
         */
        singlePlayerMode.setOnClickListener(this);
        multiPlayerMode.setOnClickListener(this);
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

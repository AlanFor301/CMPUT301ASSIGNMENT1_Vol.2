package com.example.qyu4.reflectontester;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * this project is for CMPUT301 assignment 1.
 * It's a free to use in any ways.
 * load and save file method is cited from Joshua2ua https://github.com/joshua2ua/lonelyTwitter
 * http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
 * Starting a system time point for single player
 */
public class MultiPlayerActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_player_activity);
        Button twoPlayerMode = (Button) findViewById(R.id.b_choose_two_player_model);
        Button threePlayerMode = (Button) findViewById(R.id.b_choose_three_player_model);
        Button fourPlayerMode = (Button) findViewById(R.id.b_choose_four_player_model);
        //Button fivePlayerMode = (Button) findViewById(R.id.b_choose_five_player_model);
        twoPlayerMode.setOnClickListener(this);
        threePlayerMode.setOnClickListener(this);
        fourPlayerMode.setOnClickListener(this);
        //fivePlayerMode.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_choose_two_player_model){
            classIntent(TwoPlayer.class);
        }
        else if(view.getId()==R.id.b_choose_three_player_model){
            classIntent(ThreePlayer.class);
        }
        else if(view.getId()==R.id.b_choose_four_player_model){
            classIntent(FourPlayer.class);
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
}

package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FourPlayer extends Activity implements OnClickListener {

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
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_fourplayer){
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_two_in_fourplayer) {
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_three_in_fourplayer){
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_four_in_fourplayer){
            classIntent(ResultPage.class);
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

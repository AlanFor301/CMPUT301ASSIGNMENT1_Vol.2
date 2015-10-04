package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreePlayer extends Activity implements OnClickListener {

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
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_threeplayer){
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_two_in_threeplayer) {
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_three_in_threeplayer){
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

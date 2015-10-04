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

public class TwoPlayer extends Activity implements OnClickListener {

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
    public void onClick(View view) {
        if(view.getId()==R.id.b_player_one_in_twoplayer){
            classIntent(ResultPage.class);
        }
        else if(view.getId()==R.id.b_player_two_in_twoplayer) {
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

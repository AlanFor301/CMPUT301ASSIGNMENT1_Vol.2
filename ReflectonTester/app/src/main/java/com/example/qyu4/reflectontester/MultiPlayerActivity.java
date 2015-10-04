package com.example.qyu4.reflectontester;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiPlayerActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_player_activity);
        Button twoPlayerMode = (Button) findViewById(R.id.b_choose_two_player_model);
        Button threePlayerMode = (Button) findViewById(R.id.b_choose_three_player_model);
        Button fourPlayerMode = (Button) findViewById(R.id.b_choose_four_player_model);
        Button fivePlayerMode = (Button) findViewById(R.id.b_choose_five_player_model);
        twoPlayerMode.setOnClickListener(this);
        threePlayerMode.setOnClickListener(this);
        fourPlayerMode.setOnClickListener(this);
        fivePlayerMode.setOnClickListener(this);
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
        else if(view.getId()==R.id.b_choose_five_player_model){
            classIntent(FivePlayer.class);
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

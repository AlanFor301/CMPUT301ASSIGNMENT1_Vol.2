package com.example.qyu4.reflectontester;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class SinglePlayerReflectionActivity extends Activity implements OnClickListener {
    public long startTime;
    private static final String FILENAME = "singlePlayer.sav";
    private ArrayList<SinglePlayerModel> singlePlayerList = new ArrayList<>();
    private ArrayAdapter adapter;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_reflection_activity);
        Button clickButton = (Button) findViewById(R.id.b_single_player_click);
        lv = (ListView) findViewById(R.id.lv_single_reaction_time);
        clickButton.setOnClickListener(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile();
        /**http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
         * Starting a system time point for single player
         */
        startTime = System.nanoTime();
        adapter   = new ArrayAdapter<>(this,
                R.layout.list_item, singlePlayerList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b_single_player_click){
            setResult(RESULT_OK);
            //Button singleReadyButton = (Button) findViewById(R.id.b_single_player_click);
            final TextView tv = (TextView) findViewById(R.id.single_player_result);
            double estimatedTime = (System.nanoTime() - startTime) / 1000000;

            tv.setText(String.valueOf(estimatedTime));
            singlePlayerList.add(new SinglePlayerModel(estimatedTime));
            saveInFile();
            adapter.notifyDataSetChanged();

        }

    }
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson  =new Gson();
            gson.toJson(singlePlayerList, out);
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
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            //******************************************//
            Gson gson = new Gson();
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arrayListType = new TypeToken<ArrayList<SinglePlayerModel>>(){}.getType();
            singlePlayerList = gson.fromJson(in, arrayListType);
            //******************************************//

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            singlePlayerList = new ArrayList<SinglePlayerModel>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

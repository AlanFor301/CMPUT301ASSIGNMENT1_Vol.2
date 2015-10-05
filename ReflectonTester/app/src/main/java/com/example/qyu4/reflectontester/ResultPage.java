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
    private static final String PLAYERONEINFIVEPALYERFILENAME    = "PlayerOneInFivePlayer.sav";
    private static final String PLAYERTWOINFIVEPALYERFILENAME    = "PlayerTwoInFivePlayer.sav";
    private static final String PLAYERTHREEINFIVEPALYERFILENAME  = "PlayerThreeInFivePlayer.sav";
    private static final String PLAYERFOURINFIVEPALYERFILENAME   = "PlayerFourInFivePlayer.sav";
    private static final String PLAYERFIVEINFIVEPALYERFILENAME   = "PlayerFiveInFivePlayer.sav";
    private ArrayList<SinglePlayer> singlePlayerStat = new ArrayList<SinglePlayer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page_activity);


    }


}

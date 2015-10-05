package com.example.qyu4.reflectontester;

/**
 * Created by qyu4 on 10/4/15.
 */
public class SinglePlayer extends SinglePlayerModel {

    public SinglePlayer(double reflectionTimeInMilliSecond) {
        super(reflectionTimeInMilliSecond);
    }
    public boolean isSinglePlayer(){
        return true;
    }
}

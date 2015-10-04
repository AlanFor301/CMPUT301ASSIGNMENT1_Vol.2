package com.example.qyu4.reflectontester;

/**
 * Created by qyu4 on 10/3/15.
 */
public class PlayerOne extends MultiPlayerModel {
    public PlayerOne(int buzzCount) {
        super(buzzCount);
    }
    public boolean isPlayerOne(){
        return true;
    }
}

package com.example.qyu4.reflectontester;

/**
 * Created by qyu4 on 10/3/15.
 *
 * this project is for CMPUT301 assignment 1.
 * It's a free to use in any ways.
 * load and save file method is cited from Joshua2ua https://github.com/joshua2ua/lonelyTwitter
 * http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
 * Starting a system time point for single player
 */

public class MultiPlayerModel {
    public int buzzCount;
    public MultiPlayerModel(int buzzCount) {
        this.setBuzzCount(buzzCount);
    }
    public int getBuzzCount() {
        return buzzCount;
    }

    public void setBuzzCount(int buzzCount) {
        this.buzzCount = buzzCount;
    }


}

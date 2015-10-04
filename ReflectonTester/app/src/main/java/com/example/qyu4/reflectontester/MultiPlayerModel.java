package com.example.qyu4.reflectontester;

/**
 * Created by qyu4 on 10/3/15.
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

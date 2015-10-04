package com.example.qyu4.reflectontester;

/**
 * Created by qyu4 on 10/3/15.
 * this model is only for single player,
 * since the content of the storing is different with multi-player model.
 */
public class SinglePlayerModel {
    public double reflectionTimeInMilliSecond;

    public SinglePlayerModel(double reflectionTimeInMilliSecond) {
        this.setReflectionTimeInMilliSecond(reflectionTimeInMilliSecond);
    }

    @Override
    public String toString() {
        return  String.valueOf(this.reflectionTimeInMilliSecond);
    }

    public double getReflectionTimeInMilliSecond() {
        return reflectionTimeInMilliSecond;
    }

    public void setReflectionTimeInMilliSecond(double reflectionTimeInMilliSecond) {
        this.reflectionTimeInMilliSecond = reflectionTimeInMilliSecond;
    }
}

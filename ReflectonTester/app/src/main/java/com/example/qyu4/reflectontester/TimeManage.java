package com.example.qyu4.reflectontester;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by qyu4 on 10/4/15.
 */
public class TimeManage {
    private double maxTen, maxOneHundred, maxAll,minTen, minOneHundred, medianTen, medianOnehundred;
    private ArrayList<SinglePlayer>singlePlayerList = new ArrayList<SinglePlayer>();
    private ArrayList singlePlayerData = new ArrayList();



    public TimeManage(ArrayList<SinglePlayer> singlePlayerList) {
        this.setSinglePlayerList(singlePlayerList);
    }

    public void setSinglePlayerList(ArrayList<SinglePlayer> singlePlayerList) {
        this.singlePlayerList = singlePlayerList;
    }

    public double getMaxTen() {

        for(int i=0; i<10; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                if(maxTen< check) maxTen=check;
            }catch (Exception e){
                return maxTen;
            }

        }

        return maxTen;
    }

    public double getMaxAll() {
        int listSize = singlePlayerList.size();
        for(int i=0; i<listSize; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                if(maxTen< check) maxTen=check;
            }catch (Exception e){
                return maxTen;
            }

        }

        return maxTen;
    }

    public double getMaxOneHundred() {
        for(int i=0; i<100; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                if(maxOneHundred< check) maxOneHundred=check;
            }catch (Exception e){
                return maxOneHundred;
            }

        }
        return maxOneHundred;
    }

    public double getMinTen() {
        minTen = 9999999999999999999.9;
        for(int i=0; i<10; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                if(minTen> check) minTen=check;
            }catch (Exception e){
                return minTen;
            }

        }
        return minTen;
    }

    public double getMinOneHundred() {
        minOneHundred = 9999999999999999999.9;
        for(int i=0; i<100; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                if(minOneHundred> check) minOneHundred=check;
            }catch (Exception e){
                return minOneHundred;
            }

        }
        return minOneHundred;
    }

    public double getMedianTen() {
        for(int i=0; i<10; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                singlePlayerData.add(check);
            }catch (Exception e){
                Collections.sort(singlePlayerData);
                int middleSlot = singlePlayerData.size()/2;
                medianTen =(double) singlePlayerData.get(middleSlot);
                return medianTen;
            }

        }
        Collections.sort(singlePlayerData);
        int middleSlot = singlePlayerData.size()/2;
        medianTen =(double) singlePlayerData.get(middleSlot);

        return medianTen;
    }

    public double getMedianOnehundred() {
        for(int i=0; i<100; i++){
            try {
                double check = singlePlayerList.get(i).getReflectionTimeInMilliSecond();
                singlePlayerData.add(check);
            }catch (Exception e){
                Collections.sort(singlePlayerData);
                int middleSlot = singlePlayerData.size()/2;
                medianOnehundred =(double) singlePlayerData.get(middleSlot);
                return medianOnehundred;
            }

        }
        Collections.sort(singlePlayerData);
        int middleSlot = singlePlayerData.size()/2;
        medianOnehundred =(double) singlePlayerData.get(middleSlot);
        return medianOnehundred;
    }

}

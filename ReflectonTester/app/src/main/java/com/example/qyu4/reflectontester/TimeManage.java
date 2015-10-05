package com.example.qyu4.reflectontester;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by qyu4 on 10/4/15.
 *
 * this project is for CMPUT301 assignment 1.
 * It's a free to use in any ways.
 * load and save file method is cited from Joshua2ua https://github.com/joshua2ua/lonelyTwitter
 * http://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
 * Starting a system time point for single player
 */

public class TimeManage {
    private double maxTen, maxOneHundred, maxAll, minAll, medianAll,minTen,
            minOneHundred, medianTen, medianOnehundred, averageTen, averageOneHundred, averageAll;
    private int playerOneInTwoPlayer;
    private ArrayList<SinglePlayer>singlePlayerList = new ArrayList<SinglePlayer>();
    private ArrayList<PlayerOne>playerOneList = new ArrayList<PlayerOne>();
    private ArrayList singlePlayerData = new ArrayList();
    private ArrayList singlePlayerAverage = new ArrayList();

    public double getAverageAll() {
        double total = 0.0;
        for(int i=1; i<=singlePlayerList.size(); i++){
            double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
            total = total + check;
        }
        averageAll = total/singlePlayerList.size();
        return averageAll;
    }

    public double getAverageTen() {
        double total = 0.0;
        for(int i=1; i<=10; i++){
            double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
            total= total +check;
        }
        averageTen = total/singlePlayerList.size();
        return averageTen;
    }

    public double getAverageOneHundred() {
        double total = 0.0;
        if(singlePlayerList.size()>=100){
            for(int i=1; i<=singlePlayerList.size(); i++) {
                double check = singlePlayerList.get(singlePlayerList.size()- i).getReflectionTimeInMilliSecond();
                total = total + check;
            }
        }else{
            total = getAverageAll();
        }
        averageOneHundred = total/singlePlayerList.size();
        return averageOneHundred;
    }


    public TimeManage(ArrayList<SinglePlayer> singlePlayerList) {
        this.setSinglePlayerList(singlePlayerList);
    }

    public void setSinglePlayerList(ArrayList<SinglePlayer> singlePlayerList) {
        this.singlePlayerList = singlePlayerList;
    }

    public double getMaxTen() {
        if(singlePlayerList.size()>=10){
            for(int i=1; i<10; i++){
                double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
                if(maxTen< check) maxTen=check;
            }
        }else{
            maxTen = getMaxAll();
        }


        return maxTen;
    }
    public double getMaxOneHundred() {
        if (singlePlayerList.size() >= 100) {
            for (int i = 1; i < 100; i++) {
                double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
                if (maxOneHundred < check) maxOneHundred = check;
            }
        }else{
            maxOneHundred = getMaxAll();
        }

        return maxOneHundred;
    }



    public double getMinTen() {
        minTen = 9999999999999999999.9;
        for(int i=1; i<10; i++){
            try {
                double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
                if(minTen> check) minTen=check;
            }catch (Exception e){
                return minTen;
            }

        }
        return minTen;
    }

    public double getMinOneHundred() {
        minOneHundred = 9999999999999999999.9;
        if(singlePlayerList.size()>=100){
            for(int i=1; i<=100; i++){
                double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
                if(minOneHundred> check) minOneHundred=check;
            }
        }else{
            minOneHundred = getMinAll();
        }

        return minOneHundred;
    }
    public double getMinAll() {
        minAll = 9999999999999999999.9;
        int listSize = singlePlayerList.size();
         for(int i=1; i<=listSize; i++){
             double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
             if(minAll> check) minAll=check;

         }
        return minAll;
    }
    public double getMaxAll() {
        maxAll = 0.0;
        for(int i=1; i<=singlePlayerList.size(); i++){
            double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
            if(maxAll< check) maxAll=check;
        }
        return maxAll;
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
        if(singlePlayerList.size()>100){
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
        }else{
            medianOnehundred = getMedianAll();
        }
        return medianOnehundred;
    }
    public double getMedianAll() {
        for(int i=1; i<=singlePlayerList.size(); i++){
                double check = singlePlayerList.get(singlePlayerList.size()-i).getReflectionTimeInMilliSecond();
                singlePlayerData.add(check);
        }
        Collections.sort(singlePlayerData);
        int middleSlot = singlePlayerData.size()/2;
        medianAll =(double) singlePlayerData.get(middleSlot);

        return medianAll;
    }

}

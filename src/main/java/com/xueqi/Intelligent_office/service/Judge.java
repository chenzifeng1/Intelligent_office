package com.xueqi.Intelligent_office.service;

public class Judge {

    public static boolean timeJ(long currnent,long set){

        return false;
    }

    public static boolean numRangeJ(int current ,int max,int min){
        return Math.max(current,min)==Math.min(current,max);
    }
}

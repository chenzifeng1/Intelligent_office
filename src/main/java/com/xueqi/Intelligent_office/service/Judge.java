package com.xueqi.Intelligent_office.service;

import java.text.SimpleDateFormat;

public class Judge {

    public static boolean timeOnDay(long aim, long currnent) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String day1 = s.format(aim);
        String day2 = s.format(currnent);
        if (day1.equals(day2))
            return true;
        else
            return false;
    }

    public static boolean numRangeJ(int current, int max, int min) {
        return Math.max(current, min) == Math.min(current, max);
    }
}

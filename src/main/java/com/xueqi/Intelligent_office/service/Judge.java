package com.xueqi.Intelligent_office.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judge {
    private static Log log = LogFactory.getLog("Judge:");
    public static boolean timeOnDay(long aim, long currnent) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String day1 = s.format(aim);
        String day2 = s.format(currnent);
        return day1.equals(day2);
    }

    public static boolean numRangeJ(int current, int max, int min) {
        return Math.max(current, min) == Math.min(current, max);
    }

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            log.error("手机号位数错误");
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();

            if (!isMatch) {
               log.error("请填入正确的手机号");
            }
            return isMatch;
        }
    }
}

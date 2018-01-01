package com.cn.manage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String TIMEPATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMEPATTERN_HHMM = "yyyy-MM-dd HH:mm";
    public static final String TIMEPATTERN_HHMM_CN = "yyyy\u5E74MM\u6708dd\u65E5 HH:mm";
    public static final String TIMEPATTERN_YYYYMMDD = "yyyy-MM-dd";
    public static final String MY_DATE_FORMAT_YMD = "yyyyMMdd";
    public static final String TIMEPATTERN_YYYYMM = "yyyy-MM";
    public static final String TIMEPATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public DateUtils() {
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    public static String getNowSecond(){
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        return retStrFormatNowDate;
    }

}

package com.dong.commons.utils;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public final class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_00_00 = "yyyy-MM-dd HH:00:00";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHH = "yyyyMMddHH";
    public static final String YYYY_MM_DD_HH_MM_SSS = "yyyy-MM-dd HH:mm:ss'.'SSS";
    public static final String YYYY_MM_DD_HH_MM_SS_ZZZ = "yyyy-MM-dd HH:mm:ss'.'SSSZZZ";
    public static final String ERA = "1970-01-01 08:00:00";

    private DateUtil() {

    }
    /**
     * 时间戳转换为指定格式的时间
     *
     * @Author CCG
     * @Date 2018/12/11 19:44
     * @Param [stamp, format]
     **/
    public static String stampToDate(Long stamp, String format) {
        if (stamp == null || stamp == 0) {
            return "";
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis((stamp * 1000L));
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        return format1.format(gc.getTime());
    }

}

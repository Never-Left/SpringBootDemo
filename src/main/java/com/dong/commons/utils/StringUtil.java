package com.dong.commons.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * @Author CCG
 * @Date 2019/12/10 10:25
 * @Version 1.0
 **/
public final class StringUtil {
    private StringUtil() {

    }

    public static String genRandomStr(int digit) {
        String code = "";
        char[] arr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57,//从0到9的数字
                65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,//从A到Z的数字
                97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122//从a到z的数字
        };
        int i = 1;
        while (i++ <= digit) { //循环N次，得到N位数的验证码
            char msg = arr[(int) (Math.random() * 62)];
            code += msg;
        }
        return code;
    }
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day).append("天");
        }
        if (hour > 0) {
            sb.append(hour).append("小时");
        }
        if (minute > 0) {
            sb.append(minute).append("分");
        }
        if (second > 0) {
            sb.append(second).append("秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond).append("毫秒");
        }
        return sb.toString();
    }

    /**
     * 对指定值就行过滤，将-替换为空
     * appsflyer过滤: -
     * 头条过滤: null，__NULL__，__OAID__，__OAID_MD5__， __ANDROIDID__，__MAC__，__MAC1__，__IP__，__UA__,
     *          __AID__，__CID__，__CALLBACK_URL__
     * 空字符串加密md5('')：d41d8cd98f00b204e9800998ecf8427e(32位) 8f00b204e9800998(16位)
     *
     * @param value 指定值
     * @return 替换后的结果
     */
    public static String filterEmptyField(String value) {
        String trimValue = StringUtils.trim(value);

        if (StringUtils.isEmpty(trimValue)
                || StringUtils.equals("-", trimValue)
                || StringUtils.equalsIgnoreCase("d41d8cd98f00b204e9800998ecf8427e", trimValue)
                || StringUtils.equals("null", trimValue)
                || StringUtils.equals("__NULL__", trimValue)
                || StringUtils.equals("__OAID__", trimValue)
                || StringUtils.equals("__OAID_MD5__", trimValue)
                || StringUtils.equals("__ANDROIDID__", trimValue)
                || StringUtils.equals("__MAC__", trimValue)
                || StringUtils.equals("__MAC1__", trimValue)
                || StringUtils.equals("__IP__", trimValue)
                || StringUtils.equals("__UA__", trimValue)
                || StringUtils.equals("__AID__", trimValue)
                || StringUtils.equals("__CID__", trimValue)
                || StringUtils.equals("__CALLBACK_URL__", trimValue)) {
            return StringUtils.EMPTY;
        }

        return trimValue;
    }

    /**
     * 提取括号内的值
     * 如facebook (23845854555770371)
     *
     * @return 括号内的值，如23845854555770371
     */
    public static String extractBracketValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return StringUtils.EMPTY;
        }

        String filterValue = filterEmptyField(value);
        if (StringUtils.isEmpty(filterValue)) {
            return StringUtils.EMPTY;
        }

        int begin = -1;
        int end = -1;

        if (filterValue.contains("(")) {
            begin = filterValue.lastIndexOf("(");
            end = filterValue.lastIndexOf(")");
        }
        else if (filterValue.contains("（")) {
            begin = filterValue.lastIndexOf("（");
            end = filterValue.lastIndexOf("）");
        }

        String result = StringUtils.EMPTY;
        if (begin > -1 && end > -1) {
            result = filterValue.substring(begin + 1, end);
        }

        return result;
    }
}

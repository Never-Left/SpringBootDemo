package com.dong.commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by fengxk on 2018/6/26.
 */
public final class MathUtil {
    private static final int DEF_DIV_SCALE = 2;

    // 这个类不能实例化
    private MathUtil() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2) {
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "null".equals(v2)) {
            v2 = "0";
        }
        if ("0".equals(v1) || "".equals(v1) || v1 == null || "null".equals(v1)) {
            v1 = "0";
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).toString();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2) {
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "null".equals(v2)) {
            v2 = "0.00";
        }
        if ("0".equals(v1) || "".equals(v1) || v1 == null || "null".equals(v1)) {
            v1 = "0.00";
        }
        BigDecimal b1 = new BigDecimal(v1);

        BigDecimal b2 = new BigDecimal(v2);

        return b1.subtract(b2).toString();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2) {
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "0".equals(v1) || "".equals(v1) || v1 == null || "null".equals(v1) || "null".equals(v2)) {
            return "0.00";
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static String div(String v1, String v2) {
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "0".equals(v1) || "".equals(v1) || v1 == null || "null".equals(v1) || "null".equals(v2)) {
            return "0.00";
        }
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (null != v1) {
            v1 = v1.replace("￥", "");
        }
        if (null != v2) {
            v2 = v2.replace("￥", "");
        }
        if ("0".equals(v1) || "".equals(v1) || v1 == null || "0.0".equals(v1) || "0.00".equals(v1) || "null".equals(v1)) {
            return "0.00";
        }
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "0.0".equals(v2) || "0.00".equals(v2) || "null".equals(v2)) {
            return "0.00";
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String div(Integer v1, Integer v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (v1 == null || v1 <= 0) {
            return "0.00";
        }
        if (v2 == null || v2 <= 0) {
            return "0.00";
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的百分比, 保留两位小数, 返回带百分号
     */
    public static String getDivPercent(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        v1 = v1.replace("￥", "");
        if (v1 == null || "".equals(v1) || "null".equals(v1) || "0".equals(v1) || "0.00".equals(v1) || "0.0".equals(v1)) {
            return "0.00%";
        }
        v2 = v2.replace("￥", "");
        if (v2 == null || "".equals(v2) || "null".equals(v2) || "0".equals(v2) || "0.00".equals(v2) || "0.0".equals(v2)) {
            return "0.00%";
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        String temp = b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(Double.parseDouble(temp));
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商乘以100 用作百分比显示，不带百分号
     */
    public static String divMul100(String v1, String v2, int scale) {
        if (null != v1) {
            v1 = v1.replace("￥", "");
        }
        if (null != v2) {
            v2 = v2.replace("￥", "");
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (v1 == null || "0".equals(v1) || "".equals(v1) || "0.00".equals(v1) || "0.0".equals(v1) || "null".equals(v1)) {
            return "0.00";
        }
        if (v2 == null || "0".equals(v2) || "".equals(v2) || "0.00".equals(v2) || "0.0".equals(v2) || "null".equals(v2)) {
            return "0.00";
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2).toString();
    }

    /**
     * 比较两个百分数
     *
     * @Author CCG
     * @Date 2018/8/23 17:05
     * @Param [v1, v2]
     * @Return int
     **/
    public static int compatrPercentNum(String v1, String v2) {
        String tempA = v1.split("%")[0];
        String tempB = v2.split("%")[0];
        // 精确表示
        BigDecimal dataA = new BigDecimal(tempA);
        BigDecimal dataB = new BigDecimal(tempB);
        return dataA.compareTo(dataB);// 大于为1，相同为0，小于为-1
    }

    /**
     * 百分数减法
     *
     * @Author CCG
     * @Date 2018/8/23 17:15
     * @Param [v1, v2]
     * @Return java.lang.String
     **/
    public static String subPercentNum(String v1, String v2) {
        String tempA = v1.split("%")[0];
        String tempB = v2.split("%")[0];
        // 精确表示
        BigDecimal dataA = new BigDecimal(tempA);
        BigDecimal dataB = new BigDecimal(tempB);
        return dataA.subtract(dataB).toString() + "%";
    }

    /**
     * 比较两个数大小返回-1 0 1
     *
     * @Author CCG
     * @Date 2018/8/29 18:55
     * @Param [v1, v2]
     * @Return int
     **/
    public static int compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).compareTo(BigDecimal.ZERO);
    }

    /**
     * (v1-v2)/v2
     *
     * @Author CCG
     * @Date 2019/7/10 11:33
     * @Param [v1, v2]
     **/
    public static String subDiv(String v1, String v2) {
        if (v1 == null || "0".equals(v1) || "".equals(v1) || "0.00".equals(v1) || "0.0".equals(v1) || "null".equals(v1)) {
            return "0.00%";
        }
        if (v2 == null || "0".equals(v2) || "".equals(v2) || "0.00".equals(v2) || "0.0".equals(v2) || "null".equals(v2)) {
            return "0.00%";
        }
        return getDivPercent(sub(v1, v2), v2, 4);
    }

    /**
     * 小数点后2位
     *
     * @Author CCG
     * @Date 2019/7/10 12:08
     * @Param [v1]
     **/
    public static String formatString(String v1) {
        if (v1 == null || "".equals(v1) || "null".equals(v1)) {
            return "0.00";
        }
        return new BigDecimal(v1).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static BigDecimal bigdecimal2Round(BigDecimal value) {
        if (value == null || BigDecimal.ZERO.equals(value)) {
            return new BigDecimal("0.00");
        }
        return value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static String[] average() {
        return null;

    }

    public static void main(String[] args) {
        String ss = MathUtil.divMul100("12", "24", 4);
        System.out.println(ss + "------------------------------");
    }


    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。返回时去掉小数点及后面小数.
     * zhangdong
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     *
     *
     */
    public static String divii(String v1, String v2, int scale) {
        if (null != v1) {
            v1 = v1.replace("￥", "");
        }
        if (null != v2) {
            v2 = v2.replace("￥", "");
        }
        if ("0".equals(v1) || "".equals(v1) || v1 == null || "0.0".equals(v1) || "0.00".equals(v1) || "null".equals(v1)) {
            return "0";
        }
        if ("0".equals(v2) || "".equals(v2) || v2 == null || "0.0".equals(v2) || "0.00".equals(v2) || "null".equals(v2)) {
            return "0";
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

}

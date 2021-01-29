package com.dong.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

public class Md5Util {


    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 16位MD5加密
     *
     * @Author CCG
     * @Date 2018/12/18 16:18
     * @Param [origin]
     **/
    public static String MD5Encode16(String origin) {
        return MD5Encode32(origin).substring(8, 24);
    }

    /**
     * MD5 16位加密
     *
     * @Author CCG
     * @Date 2018/12/11 18:33
     * @Param [origin, charsetname]
     **/
    public static String MD5Encode32(String origin, String charsetname) {
        String resultString = null;
        if (charsetname == null || "".equals(charsetname)) {
            charsetname = "utf-8";
        }
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }

    /**
     * MD5 32位加密
     *
     * @Author CCG
     * @Date 2018/12/11 18:34
     * @Param [encryptStr]
     **/
    public static String MD5Encode32(String encryptStr) {
        return MD5Encode32(encryptStr, null);
    }

    /**
     * 32位加密转16位加密 截取6-24位
     *
     * @Author CCG
     * @Date 2018/12/18 16:11
     * @Param [encode32]
     **/
    public static String encode32to16(String encode32) {
        if (!StringUtils.isEmpty(encode32) && encode32.length() == 32)
            return encode32.substring(8, 24);
        return "";
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}

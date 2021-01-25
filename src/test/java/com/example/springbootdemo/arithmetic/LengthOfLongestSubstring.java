package com.example.springbootdemo.arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 3.无重复字符串的最长子串
 * @author: dong.zhang
 * @time: 2021/1/15
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 无重复字符串的最长子串
     *
     * @return int
     * @params [s]
     * @author jingjing.meng
     * @date 2021/1/13 19:28
     **/
    public int lengthOfLongestSubstring(String str) {
        int index = 0, max = 0;
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            while (index < str.length() && !result.contains(str.charAt(index))) {
                result.add(str.charAt(index));
                index++;
            }
            System.out.println(result.toString());
            max = Math.max(max, index - i);
            result.remove(str.charAt(i));
        }
        return max;
    }

    /**
     * 无重复字符串的最长子串
     *
     * @return int
     * @params [s]
     * @author dong.zhang
     * @date 2021/1/13 19:38
     **/
    public int lengthOfLongestSubstring2(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.substring(i, i + 1));
        }
        for (int i = set.size(); i > 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                try {
                    String str = s.substring(j, i + j);
                    Set<String> set2 = new HashSet<>();
                    for (int k = 0; k < str.length(); k++) {
                        set2.add(str.substring(k, k + 1));
                    }
                    if (set2.size() == str.length()) {
                        return str.length();
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return 0;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int res = 0;//记录最长子串的长度
        int end = 0, start = 0;//记录开始和结尾的下标
        Set<Character> set = new HashSet<>();//使用set容器不重复
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {//如果窗口右侧的字符已经存在
                set.remove(s.charAt(start++));//左侧窗口边界向右
            } else {
                set.add(s.charAt(end++));//如果窗口中无重复，窗口右侧向右滑动
                res = Math.max(res, end - start);//同时记录当前最大长度
            }
        }
        return res;
    }


}


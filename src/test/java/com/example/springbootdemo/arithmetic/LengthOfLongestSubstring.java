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
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2("aabaab!bb"));
    }

    /**
     * 无重复字符串的最长子串
     *
     * @return int
     * @params [s]
     * @author dong.zhang
     * @date 2021/1/13 19:28
     **/
    public int lengthOfLongestSubstring(String s) {
        int len = 0, max = 0;
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (len < s.length() && !result.contains(s.charAt(len))) {
                result.add(s.charAt(len));
                ++len;
            }
            System.out.println(result.toString());
            max = Math.max(max, len - i);
            result.remove(s.charAt(i));
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
}


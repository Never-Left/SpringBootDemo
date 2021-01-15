package com.example.springbootdemo.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: dong.zhang
 * @time: 2021/1/12
 */
public class TwoSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4, 2};
        int target = 6;
        int[] result = twoSum4(arr, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * 两数之和
     *
     * @return int[]
     * @params [nums, target]
     * @author dong.zhang
     * @date 2021/1/12 20:25
     **/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 两数之和
     *
     * @return int[]
     * @params [nums, target]
     * @author dong.zhang
     * @date 2021/1/12 10:53
     **/
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = i;
            for (int j = 0; j < nums.length; j++) {
                int num2 = j;
                if (nums[i] + nums[j] == target) {
                    if (i == j) {
                        continue;
                    }
                    return new int[]{num1, num2};
                }
            }
        }
        return null;
    }

    /**
     * 两数之和
     *
     * @return int[]
     * @params [nums, target]
     * @author dong.zhang
     * @date 2021/1/12 20:36
     **/
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 两数之和
     *
     * @return int[]
     * @params [nums, target]
     * @author dong.zhang
     * @date 2021/1/12 21:46
     **/
    public static int[] twoSum4(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[i] + nums[j] == target) {
                    if (i != j) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

}


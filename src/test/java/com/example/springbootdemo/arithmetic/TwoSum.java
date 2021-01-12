package com.example.springbootdemo.arithmetic;

/**
 * @description: 两数之和
 * @author: dong.zhang
 * @time: 2021/1/12
 */
public class TwoSum {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 5, 11};
        int target = 10;
        int[] result = twoSum(arr, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    /**
     * 两数之和
     *
     * @return int[]
     * @params [nums, target]
     * @author dong.zhang
     * @date 2021/1/12 10:53
     **/
    public static int[] twoSum(int[] nums, int target) {
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

}


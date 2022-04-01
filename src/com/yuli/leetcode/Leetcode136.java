package com.yuli.leetcode;

/**
 * 136. 只出现一次的数字
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result  ^ num;
        }
        return result;
    }
}

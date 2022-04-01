package com.yuli.leetcode;

/**
 * 移动零
 * 采用双指针
 */
public class Leetcode283 {

    public void moveZeroes(int[] nums) {
        int j = 0;//0位指针
        for (int i = 0; i < nums.length; i++) {
            //如果i遍历到不等于零，就是数据放到j上，并且j+1
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //从j的位置把数组后续的数据置为0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

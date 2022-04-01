package com.yuli.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * 解题思路：遍历数组，将数组种对对应数据相应下标的数据改为负数，再次遍历该数据，没有为负数的该索引+1就是没有出现的数据
 */
public class Leetcode448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i])-1;
            if (nums[abs] > 0)
                nums[abs] = 0 - (nums[abs]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}

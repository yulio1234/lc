package com.yuli.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 解题思路：遍历的时候把已经访问的数存储缓存种，计算两数之和的另一个数是否在缓存种存在
 */
public class Leetcode1 {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int another = target - nums[i];
            if (cache.containsKey(another)) {
                result[0] = i;
                result[1] = cache.get(another);
                return result;
            }
            cache.put(nums[i],i);
        }
        return null;
    }
}

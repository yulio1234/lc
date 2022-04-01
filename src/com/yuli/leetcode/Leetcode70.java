package com.yuli.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 采用递归
 */
public class Leetcode70 {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }
}

package com.yuli.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 */
public class Offer10 {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = fib(n - 1) + fib(n - 2);
        cache.put(n,result);
        return result;
    }
}

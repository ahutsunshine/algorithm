package com.algorithm.leetcode.common;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 2的0次方 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 2的4次方 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */

public class _231_PowerOfTwo {
    public static void main(String[] args) {
        int n = 1;
        assert (isPowerOfTwo1(n));
        assert (isPowerOfTwo2(n));

        n =  14;
        assert (!isPowerOfTwo1(n));
        assert (!isPowerOfTwo2(n));
    }

    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }

}

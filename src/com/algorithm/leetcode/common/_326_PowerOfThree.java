package com.algorithm.leetcode.common;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 */

public class _326_PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        assert (isPowerOfThree(n));

        n = 0;
        assert (!isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }
}

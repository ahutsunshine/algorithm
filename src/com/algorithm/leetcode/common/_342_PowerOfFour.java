package com.algorithm.leetcode.common;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 */

public class _342_PowerOfFour {
    public static void main(String[] args) {
        int n = 16;
        assert (isPowerOfFour1(n));
        assert (isPowerOfFour2(n));

        n = 5;
        assert (!isPowerOfFour1(n));
        assert (!isPowerOfFour2(n));
    }

    public static boolean isPowerOfFour1(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public static boolean isPowerOfFour2(int num) {
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}

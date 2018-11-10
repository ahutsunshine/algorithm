package com.algorithm.leetcode.common;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 *
 */

public class _367_ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 16;
        assert (isPerfectSquare1(num));
        assert (isPerfectSquare2(num));
        assert (isPerfectSquare3(num));

        num = 14;
        assert (!isPerfectSquare1(num));
        assert (!isPerfectSquare2(num));
        assert (!isPerfectSquare3(num));
    }

    public static boolean isPerfectSquare1(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        int i;
        for(i = 2; i < num / i;i++);
        return i * i == num;
    }

    /**
     * 利用性质：完全平方数是一系列奇数之和，例如：
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * 时间复杂度为O(sqrt(n))
     */
    public static boolean isPerfectSquare2(int num) {
        if(num <= 0) return false;
        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    /**
     * 基于二分查找的思想
     * 时间复杂度为O(log(n))
     */
    public static boolean isPerfectSquare3(int num) {
        int low = 1, high = num;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) high = (int)(mid - 1);
            else low = (int)(mid + 1);
        }
        return false;
    }


}

package com.algorithm.leetcode.common;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 */

public class _371_SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 1, b = 2;
        assert (getSum(a, b) == 3);

        a = -2;
        b = 3;
        assert (getSum(a, b) == 1);
    }

    public static int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int carry;
        while(b != 0){
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

package com.algorithm.leetcode.common;

/**
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 *   ¤
 *   ¤ ¤
 *   ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 *   ¤
 *   ¤ ¤
 *   ¤ ¤ ¤
 *   ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */

public class _441_ArrangingCoins {
    public static void main(String[] args) {
        int n = 5;
        assert arrangeCoins1(n) == 2;
        assert arrangeCoins2(n) == 2;

        n = 12345678;
        assert arrangeCoins1(n) == 4968;
        assert arrangeCoins2(n) == 4968;
    }

    public static int arrangeCoins1(int n) {
        if(n <= 0) return 0;
        long low = 1, high = n;
        while(low <= high){
            long mid = low + (high - low) / 2;
            long res = mid * (mid + 1);
            if(mid * (mid + 1) == (long) n * 2) return (int)mid;
            else if(res > (long) n * 2) high = mid -1;
            else low = mid + 1;
        }
        return (int)(low - 1);
    }

    public static int arrangeCoins2(int n) {
        if(n <= 0) return 0;
        return (int)((-1 + Math.sqrt(1 + (long)8 * n))/2);
    }
}

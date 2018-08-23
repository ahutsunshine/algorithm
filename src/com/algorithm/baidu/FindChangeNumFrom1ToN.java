package com.algorithm.baidu;
/**
 * 一个数组乱序存储1到100，将数组中某个数变为-1，怎么查找这个数以及该数的下标？
 * 要求时间复杂度O(n)，空间复杂度O(1)
 * 此题与下一题思路相同
 * 1-N的自然数中，少了一个，找出这个数
 */
public class FindChangeNumFrom1ToN {
    public static void main(String[] args) {
        int[] a = {3, 2, 6, 5, -1, 1};
        System.out.println(findChangeNum(a));
    }

    private static int findChangeNum(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result ^= (i + 1);
            result ^= a[i];
        }
        result ^= -1;
        return result;
    }
}

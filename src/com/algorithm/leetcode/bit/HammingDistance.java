package com.algorithm.leetcode.bit;

// 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
//
//给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x ^ y) & 1) == 1) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));

        x = 3;
        y = 1;
        System.out.println(hammingDistance(x, y));
    }
}

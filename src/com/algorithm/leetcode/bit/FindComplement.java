package com.algorithm.leetcode.bit;

public class FindComplement {
    public static int findComplement(int num) {
        int highest = 0, sum = 0;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                highest = i;
                break;
            }
        }
        for (int i = 0; i < highest; i++) {
            if (((num >> i) & 1) == 0) {
                sum = sum | (1 << i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 55;
        System.out.println(findComplement(num));

        num = 1;
        System.out.println(findComplement(num));
    }
}

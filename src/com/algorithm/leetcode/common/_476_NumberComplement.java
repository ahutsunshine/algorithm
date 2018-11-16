package com.algorithm.leetcode.common;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits),
 * and its complement is 0. So you need to output 0.
 * */
public class _476_NumberComplement {

    public static void main(String[] args) {
        int num = 5;
        assert findComplement1(num) == 2;
        assert findComplement2(num) == 2;
        assert findComplement3(num) == 2;
        assert findComplement4(num) == 2;
    }

    /**
     * suppose int is 8 bit.
     * num =0000 0101, ~num = 1111 1010
     * Integer.highestOneBit(num) = 0000 0100
     * Integer.highestOneBit(num) << 1 = 0000 1000
     * Integer.highestOneBit(num) << 1 -1 = 0000 0111
     * return  ~num & ((Integer.highestOneBit(num) << 1) - 1) = 1111 1010 & 0000 0111 = 0000 0010
     */
    public static int findComplement1(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    /**
     * num = 0100 1001, the purpose is to get 0111 1111
     * i = num | num >> 1 = 0110 0100
     * i |= i >> 2, i = 0111 1001
     * i |= i >> 4, i = 0111 1111
     * i |= i >> 8, i = 0111 1111
     * i |= i >> 16,i = 0111 1111
     * i - num, return 0011 0110
     */
    public static int findComplement2(int num) {
        int i = num | num >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        i |= i >> 16;
        return i - num;
    }

    /**
     * num = 0100 1001, the purpose is to get 0111 1111
     */
    public static int findComplement3(int num) {
        int i = 0;
        int j = 0;
        while (i < num) {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }

    public static int findComplement4(int num) {
        String s = Integer.toBinaryString(num);
        char[] res = s.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if(res[i] == '0') res[i] = '1';
            else res[i] = '0';
        }
        return Integer.parseInt(String.valueOf(res),2);
    }
}

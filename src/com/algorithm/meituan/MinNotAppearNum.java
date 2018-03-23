package com.algorithm.meituan;

import java.util.Scanner;

/**
 * @author deyyao
 * description:给定一串字符串，每个字符均在0-9之间，可能有些正整数无法表示出来，
 * 比如你有字符串是112，你可能表示出11，12，121等，但无法表示出10，122，200等数
 * 求你所无法组成的最小的正整数是多少？
 * 例如：输入55 输出1；输入123456789 输出10；输入12345678901 输出22
 *
 */
public class MinNotAppearNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int[] a = new int[10];
        char[] c = s.toCharArray();
        int min = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < c.length; i++) {
            a[c[i] - '0']++;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                flag = i;
            }
        }
        int zeronum = a[0];
        StringBuffer buffer = new StringBuffer();
        if (min <= zeronum) {
            for (int i = 0; i <= min; i++) {
                buffer.append(flag);
            }
        } else {
            buffer.append(flag);
            for (int i = 0; i <= a[0]; i++) {
                buffer.append(0);
            }
        }
        System.out.println(buffer);
    }
}

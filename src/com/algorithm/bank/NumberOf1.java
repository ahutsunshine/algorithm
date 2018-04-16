package com.algorithm.bank;

import java.util.Scanner;

/**
 * @author Kevin Yao
 * 给出三个整数a,b,c，你需要计算2的a次方+2的b次方-2的c次方在二进制表示下1的个数
 * 1<=c<b<=10的9次方
 * 思路：提取公共部分寻找规律
 */
public class NumberOf1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int n = b - c;
        System.out.println(n + 1);
    }
}

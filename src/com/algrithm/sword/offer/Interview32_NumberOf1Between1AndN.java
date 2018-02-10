package com.algrithm.sword.offer;

public class Interview32_NumberOf1Between1AndN {
    public static void main(String[] args) {
        int n =12;
        System.out.println(NumberOf1Between1AndN_String(n));
    }

    private static int NumberOf1Between1AndN_String(int n) {
        int count = 0;
        while (n > 0) {
            count += NumberOf1_String(n);
            n--;
        }
        return count;
    }

    private static int NumberOf1_String(int n) {
        int count = 0;
        String num = String.valueOf(n);
        char[] str = num.toCharArray();
        for (char c : str) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    private static int NumberOf1_Int(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}

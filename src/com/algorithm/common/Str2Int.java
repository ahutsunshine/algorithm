package com.algorithm.common;

/**
 * @author Kevin Yao
 */
public class Str2Int {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "+123";
        String str3 = "-123";
        String str4 = "12345678901234556788989212344";
        System.out.println(str2Int(str1));
        System.out.println(str2Int(str2));
        System.out.println(str2Int(str3));
        System.out.println(str2Int(str4));
    }

    private static int str2Int(String s) {
        if (s == null || s.length() == 0) {
            throw new NullPointerException();
        }
        int len = s.length();
        boolean negtive = false;
        char[] digits = s.toCharArray();
        char firstChar = digits[0];
        int i = 0;
        long result = 0;
        if (firstChar < '0' || firstChar > '9') {
            if (firstChar == '-') {
                negtive = true;
            } else if (firstChar != '+') {
                throw new NumberFormatException("Illegal character in " + s);
            }
            if (len == 1) {
                throw new NumberFormatException("String has no number.");
            }
            i++;
        }
        while (i < len) {
            if (digits[i] < '0' || digits[i] > '9') {
                throw new NumberFormatException(s + " has non numeric character.");
            }
            result = result * 10 + digits[i++] - '0';
            if (negtive) {
                if (-result < Integer.MIN_VALUE) {
                    throw new NumberFormatException(s + " is out of bounds.");
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    throw new NumberFormatException(s + " is out of bounds.");
                }
            }
        }
        return negtive ? -(int) result : (int) result;
    }
}

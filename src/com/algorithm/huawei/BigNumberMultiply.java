package com.algorithm.huawei;

import java.util.Scanner;

public class BigNumberMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.next();
        String n2 = scanner.next();
        boolean positive = isPositive(n1, n2);
        multiply(n1, n2, positive);
    }

    private static void multiply(String n1, String n2, boolean positive) {
        n1 = n1.replace("-", "").replace("+","");
        n2 = n2.replace("-", "").replace("+","");
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();
        int[] digits = new int[n1.length() + n2.length()];
        char[] c1 = n1.toCharArray();
        char[] c2 = n2.toCharArray();
        for (int i = 0; i < n1.length(); i++) {
            int a = c1[i] - '0';
            for (int j = 0; j < n2.length(); j++) {
                int b = c2[j] - '0';
                digits[i + j] += a * b;
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] % 10;
            int carry = digits[i] / 10;
            result.insert(0, digit);
            if (i < digits.length - 1) {
                digits[i + 1] += carry;
            }
        }
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        if (result.length() == 0) {
            System.out.println("0");
        } else {
            String s = result.toString();
            System.out.println(positive ? s : "-" + s);
        }
    }

    private static boolean isPositive(String n1, String n2) {
        int neg1 = n1.contains("-") ? -1 : 1;
        int neg2 = n2.contains("-") ? -1 : 1;
        return neg1 * neg2 > 0;
    }
}

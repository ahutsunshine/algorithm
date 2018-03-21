package com.algorithm.huawei;

import java.util.Scanner;

public class ContinuousNumberMax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            dpMax(s);
        }
    }

    private static void continuousMax(String s) {
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                temp.append(c);
            } else {
                temp.append("a");
            }
        }
        String[] results = temp.toString().split("a");
        int max = 0;
        for (int i = 0; i < results.length; i++) {
            int len = results[i].length();
            max = len > max ? len : max;
        }
        String longest = "";
        for (int i = 0; i < results.length; i++) {
            if (results[i].length() == max) {
                longest = results[i];
            }
        }
        System.out.println(longest + "," + max);
    }

    private static void dpMax(String s) {
        int[] dp = new int[s.length()];
        char[] c = s.toCharArray();
        int max = 0;
        int flag = 0;
        if (c[0] >= '0' && c[0] <= '9') {
            dp[0] = 1;
        }
        for (int i = 1; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (dp[i] >= max) {
                max = dp[i];
                flag = i;
            }
        }
        System.out.println(s.substring(flag - max + 1, flag + 1) + "," + max);
    }
}

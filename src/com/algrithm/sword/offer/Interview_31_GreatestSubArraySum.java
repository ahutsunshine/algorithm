package com.algrithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_31_GreatestSubArraySum {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(getGreatestSubArraySum(a));
    }

    private static int getGreatestSubArraySum(int[] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : a) {
            if (sum < 0) {
                sum = val;
            } else {
                sum += val;
            }
            if (sum > max) {
                max=sum;
            }
        }
        return max;
    }
}

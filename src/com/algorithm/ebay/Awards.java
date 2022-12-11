package com.algorithm.ebay;

import java.util.Scanner;

public class Awards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(awards(nums));
    }

    public static int awards(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(awardsNoCircle(nums, 0, nums.length - 2), awardsNoCircle(nums, 1, nums.length - 1));
    }

    private static int awardsNoCircle(int[] nums, int start, int end) {
        int begin = 0, max = nums[start];
        for (int i = start + 1; i <= end; ++i) {
            int maxTmp = Math.max(nums[i] + begin, max);
            begin = max;
            max = maxTmp;
        }
        return max;
    }
}

package com.algorithm.leetcode.common;

public class _189_RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);

    }

    public static void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
        nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}

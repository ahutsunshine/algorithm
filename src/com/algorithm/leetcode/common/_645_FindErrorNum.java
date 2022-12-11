package com.algorithm.leetcode.common;

// 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
//
//给定一个数组 nums 代表了集合 S 发生错误后的结果。
//
//请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
//

public class _645_FindErrorNum {
    // 排序：将1-n排列在 0 - n-1的位置上，出现重复的一个即为重复值
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1]) {
                    res[0] = nums[i];
                    res[1] = i + 1;
                    return res;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return res;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] res = findErrorNums(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[] nums1 = {1, 1};
        int[] res1 = findErrorNums(nums1);
        for (int n : res1) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[] nums2 = {1, 3, 4, 5, 4};
        int[] res2 = findErrorNums(nums2);
        for (int n : res2) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[] nums3 = {2, 2};
        int[] res3 = findErrorNums(nums3);
        for (int n : res3) {
            System.out.print(n + " ");
        }
        System.out.println();

        int x = 13;
        int y  = 25;
        int xor = x ^ y;
        xor = xor ^ (-xor);
        System.out.println(x ^ xor);
        System.out.println(y ^ xor);
    }
}

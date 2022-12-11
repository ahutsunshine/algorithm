package com.algorithm.leetcode.binary_search;

import java.util.Objects;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回[-1, -1]。
//
//进阶：
//
//你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
//
//
//示例 1：
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//示例2：
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//示例 3：
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
public class SearchFirstLast {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        SearchFirstLast s = new SearchFirstLast();
//        System.out.println(Arrays.toString(s.searchRange(nums, target)));
        System.out.println(s.searchLeft(nums, target));
        System.out.println(s.searchRight(nums, target));
//        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}

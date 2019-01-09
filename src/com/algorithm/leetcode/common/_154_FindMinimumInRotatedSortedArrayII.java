package com.algorithm.leetcode.common;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 */
public class _154_FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(findMin(nums));

        int[] nums1 = {2,2,2,0,1};
        System.out.println(findMin(nums1));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length -1 ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else {
                right -- ;
            }
        }
        return nums[left];
    }
}

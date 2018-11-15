package com.algorithm.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

public class _448_FindNumsDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disNums = findDisappearedNumbers(nums);
        assert disNums.size() == 2;
        assert disNums.get(0) == 5;
        assert disNums.get(9) == 6;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) return res;
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]) - 1;
            nums[k] = nums[k] > 0 ? -nums[k] : nums[k];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}

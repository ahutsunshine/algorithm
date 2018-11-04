package com.algorithm.leetcode.tree;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * */

public class _108_ArrayToBST {
    public static TreeNode sortedArrayTOBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return convert(nums, 0, nums.length - 1);
    }

    public static TreeNode convert(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = convert(nums, low, mid - 1);
        n.right = convert(nums, mid + 1, high);
        return n;
    }
}

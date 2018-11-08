package com.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, sortedArrayTOBST it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class _108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayTOBST(nums);
        List<Integer> l = new ArrayList<>();
        inOrder(root, l);
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] == l.get(i));
        }
        System.out.println(l);
    }

    private static void inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    public static TreeNode sortedArrayTOBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return sortedArrayTOBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayTOBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayTOBST(nums, low, mid - 1);
        root.right = sortedArrayTOBST(nums, mid + 1, high);
        return root;
    }
}

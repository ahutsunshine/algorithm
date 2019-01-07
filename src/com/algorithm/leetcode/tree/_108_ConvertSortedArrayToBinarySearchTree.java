package com.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an array where elements are sorted in ascending order, sortedArrayTOBST it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
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

        root = sortedArrayToBST(nums);
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        System.out.println(res);
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        MyNode node = new MyNode(root, 0, nums.length - 1);
        Stack<MyNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            MyNode n = stack.pop();
            int m = n.left + (n.right - n.left) / 2;
            if (m - 1 >= n.left) {
                TreeNode l = new TreeNode(nums[(m - 1 + n.left) / 2]);
                MyNode left = new MyNode(l, n.left, m - 1);
                n.node.left = l;
                stack.push(left);
            }
            if (m + 1 <= n.right) {
                TreeNode r = new TreeNode(nums[(m + 1 + n.right) / 2]);
                MyNode right = new MyNode(r, m + 1, n.right);
                n.node.right = r;
                stack.push(right);
            }
        }
        return root;
    }

    static class MyNode {
        TreeNode node;
        int left;
        int right;

        MyNode(TreeNode node, int left, int right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }
}

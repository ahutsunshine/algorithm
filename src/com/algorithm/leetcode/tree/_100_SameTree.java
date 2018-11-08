package com.algorithm.leetcode.tree;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class _100_SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        p.left = p1;
        p.right = p2;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(3);
        q.left = q1;
        q.right = q2;

        assert (isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

package com.algorithm.leetcode.tree;

import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class _112_PathSum {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(8);
        TreeNode p3 = new TreeNode(11);
        TreeNode p4 = new TreeNode(13);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(2);
        TreeNode p8 = new TreeNode(1);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p2.left = p3;
        p3.left = p4;
        p3.right = p5;
        p3.left = p6;
        p3.right = p7;
        p5.right = p8;

        assert (hasPathSum(p, 22));
        assert (!hasPathSum(p, 23));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

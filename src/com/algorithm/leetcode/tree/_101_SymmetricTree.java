package com.algorithm.leetcode.tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class _101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(3);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        assert (isSymmetric(p));

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q4 = new TreeNode(3);
        q.left = q1;
        q.right = q2;
        q1.right = q3;
        q2.right = q4;
        assert (!isSymmetric(q));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}

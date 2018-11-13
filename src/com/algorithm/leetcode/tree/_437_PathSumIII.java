package com.algorithm.leetcode.tree;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *      10
 *     /  \
 *    5   -3
 *   / \    \
 *  3   2   11
 * / \   \
 *3  -2   1

 * Return 3. The paths that sum to 8 are:

 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

public class _437_PathSumIII {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(10);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(-3);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(11);
        TreeNode p6 = new TreeNode(3);
        TreeNode p7 = new TreeNode(-2);
        TreeNode p8 = new TreeNode(1);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        p4.right = p8;

        assert pathSum(p, 8) == 3;
    }
    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int pathSumNode(TreeNode root, int sum){
        if(root == null) return 0;
        int num = (root.val == sum ? 1 : 0);
        return num + pathSumNode(root.left, sum - root.val) + pathSumNode(root.right, sum - root.val);
    }
}

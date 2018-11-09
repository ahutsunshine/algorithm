package com.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

public class _113_PathSumII {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(8);
        TreeNode p3 = new TreeNode(11);
        TreeNode p4 = new TreeNode(13);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(2);
        TreeNode p8 = new TreeNode(5);
        TreeNode p9 = new TreeNode(1);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        p5.left = p8;
        p5.right = p9;

        List<List<Integer>> paths = pathSum(p, 22);
        assert (paths.size() == 2);
        System.out.println(paths);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        getPath(root, sum, path, paths);
        return paths;
    }

    public static void getPath(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            paths.add(new ArrayList<>(path));
        }
        getPath(root.left, sum - root.val, path, paths);
        getPath(root.right, sum - root.val, path, paths);
        path.remove(path.size() - 1);
    }
}

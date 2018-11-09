package com.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

public class _257_BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(5);
        p.left = p1;
        p.right = p2;
        p1.left = p3;

        List<String> paths = binaryTreePaths(p);
        assert (paths.size() == 2);
        System.out.println(paths);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getNodePath(root, "", paths);
        return paths;
    }

    public static void getNodePath(TreeNode root, String path, List<String> paths){
        if(root == null) return;
        if(root.left == null && root.right == null){
            paths.add(path + root.val);
        }
        getNodePath(root.left, path + root.val + "->", paths);
        getNodePath(root.right, path + root.val + "->", paths);
    }
}

package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTree {
    /**
     * 层次遍历构建完全二叉树，传入的数组必须是完全二叉树的格式，如果没有值，则为null
     * [1, 2, 3, null, null, 4, 5, null, null, null, null, null, 6]
     *         1
     *        / \
     *       2   3
     *          / \
     *         4   5
     *              \
     *               6
     */
    public TreeNode constructCompleteBinaryTree(Integer[] data, int k) {
        if (data == null || k >= data.length || data[k] == null) {
            return null;
        }
        TreeNode root = new TreeNode(data[k]);
        root.left = constructCompleteBinaryTree(data, 2 * k + 1);
        root.right = constructCompleteBinaryTree(data, 2 * k + 2);
        return root;
    }

    /**
     * 层次遍历构建二叉树，这种包含了上述构建完全二叉树的方式
     * [1, 2, 3, null, null, 4, 5, null, 6]
     *         1
     *        / \
     *       2   3
     *          / \
     *         4   5
     *              \
     *               6
     */
    public TreeNode constructBinaryTree(Integer[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        int i = 0;
        while (!tree.isEmpty()) {
            TreeNode cur = tree.poll();
            if (cur == null) {
                continue;
            }
            if (++i < data.length && data[i] != null) {
                TreeNode left = new TreeNode(data[i]);
                tree.add(left);
                cur.left = left;
            }
            if (++i < data.length && data[i] != null) {
                TreeNode right = new TreeNode(data[i]);
                tree.add(right);
                cur.right = right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{0, 1, 2, 3, 4, 5};
        ConstructBinaryTree c = new ConstructBinaryTree();
        TreeNode root = c.constructCompleteBinaryTree(data, 0);
        LevelTraverse.levelTraverse(root);
        System.out.println();

        data = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null, null, 6};
        c = new ConstructBinaryTree();
        root = c.constructCompleteBinaryTree(data, 0);
        LevelTraverse.levelTraverse(root);
        System.out.println();

        data = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, 6};
        c = new ConstructBinaryTree();
        root = c.constructBinaryTree(data);
        LevelTraverse.levelTraverse(root);
    }
}

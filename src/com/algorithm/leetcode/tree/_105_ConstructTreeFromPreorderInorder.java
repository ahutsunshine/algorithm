package com.algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class _105_ConstructTreeFromPreorderInorder {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        postOrder(root);

        System.out.println();
        TreeNode root1 = buildTreeRecuresive(preorder, inorder);
        postOrder(root1);

    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }

    }

    public static TreeNode buildTreeRecuresive(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int pStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (pStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = 1; i < inorder.length; i++) {
            if (inorder[i] == preorder[pStart]) {
                inIndex = i;
            }
        }
        root.left = helper(pStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(pStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode n = new TreeNode(value);
            if (map.get(value) < map.get(stack.peek().val)) {
                stack.peek().left = n;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = n;
            }
            stack.push(n);
        }
        return root;
    }
}

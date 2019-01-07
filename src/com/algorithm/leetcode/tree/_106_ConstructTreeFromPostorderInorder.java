package com.algorithm.leetcode.tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class _106_ConstructTreeFromPostorderInorder {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTreeRecursive(inorder, postorder);
        preOrder(root);

    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public static TreeNode helper(int pEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (pEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int inIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[pEnd] == inorder[i]) {
                inIndex = i;
            }
        }
        root.left = helper(pEnd - (inEnd - inIndex + 1), inStart, inIndex - 1, inorder, postorder);
        root.right = helper(pEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;

    }
}

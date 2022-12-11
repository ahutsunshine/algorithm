package com.algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostorderInorder {
    // 中序遍历map: <key, value> -> <value, index>
    private Map<Integer, Integer> indexMap;

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int inorder_root = indexMap.get(preorder[preorder_left]);
        int sub_tree_size = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + sub_tree_size, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + sub_tree_size + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructTreeFromPostorderInorder c = new ConstructTreeFromPostorderInorder();
        TreeNode root = c.buildTree(preorder, inorder);
        LevelTraverse.levelTraverse(root);
    }
}

package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraverse {
    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
            System.out.print(p.val + " ");
        }
    }
}

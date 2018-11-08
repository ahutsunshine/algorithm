package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 */

public class _110_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        p.left = p1;
        p.right = p2;
        p2.left = p3;
        p2.right = p4;
        assert (minDepth(p) == 2);
        assert (minDepthNonRecursive(p) == 2);

    }
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) return 1 + (left == 0 ? right : left);
        return 1 + Math.min(left, right);
    }

    public static int minDepthNonRecursive(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode n = q.poll();
                if(n.left == null && n.right == null) return count;
                if(n.left != null)  q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            count++;
        }
        return count;
    }
}

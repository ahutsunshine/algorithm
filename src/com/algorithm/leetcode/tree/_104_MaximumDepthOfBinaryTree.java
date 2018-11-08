package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 * return its depth = 3.
 */
public class _104_MaximumDepthOfBinaryTree {

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
        assert (maxDepth(p) == 3);
        assert (maxDepthNonRecursive(p) == 3);


    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxDepthNonRecursive(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode n = q.poll();
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            count++;
        }
        return count;
    }
}

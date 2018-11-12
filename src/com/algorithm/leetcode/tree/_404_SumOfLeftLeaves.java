package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

public class _404_SumOfLeftLeaves {
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

        assert sumOfLeftLeaves(p) == 24;
        assert sumOfLeftLeavesNonRecursive(p) == 24;

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static int sumOfLeftLeavesNonRecursive(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode n = q.poll();
                if(n.left != null){
                    if(n.left.left == null && n.left.right == null) sum += n.left.val;
                    else q.offer(n.left);
                }
                if(n.right != null){
                    q.offer(n.right);
                }
            }
        }
        return sum;
    }
}

package com.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class _107_BinaryTreeLevelOrderTraversalII {
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

        List<List<Integer>> rows = levelOrderBottom(p);
        assert (rows.size() == 3);
        assert (rows.get(0).size() == 2);
        assert (rows.get(1).size() == 2);
        assert (rows.get(2).size() == 1);
        System.out.println(rows);
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<>();
        if(root == null) return rows;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while(size-- > 0){
                TreeNode n = q.poll();
                row.add(n.val);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            rows.add(0, row);
        }
        return rows;
    }
}

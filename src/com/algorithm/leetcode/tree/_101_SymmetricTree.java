package com.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class _101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(3);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        assert (isSymmetric(p));

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q4 = new TreeNode(3);
        q.left = q1;
        q.right = q2;
        q1.right = q3;
        q2.right = q4;
        assert (!isSymmetric(q));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public static boolean isSymmetricNonRecursive(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode u = q.poll();
            TreeNode v = q.poll();
            if (u == null && v == null){
                continue;
            }
            if (u == null || v == null || u.val != v.val){
                return false;
            }
            q.add(u.left);
            q.add(v.right);

            q.add(u.right);
            q.add(v.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}

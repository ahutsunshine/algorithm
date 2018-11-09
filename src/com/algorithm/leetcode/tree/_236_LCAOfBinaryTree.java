package com.algorithm.leetcode.tree;

import java.util.Stack;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */

public class _236_LCAOfBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(6);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(8);
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;

        TreeNode lca = lowestCommonAncestor(p, p3, p4);
        assert (lca.val == 5);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        boolean pFound = getNodePath(root, p, s1);
        if(!pFound) return null;
        boolean qFound = getNodePath(root, q, s2);
        if(!qFound) return null;
        if(s1.size() < s2.size()){
            Stack<TreeNode> s = s1;
            s1 = s2;
            s2 = s;
        }
        while(s1.size() > s2.size()){
            s1.pop();
        }
        while(s1.peek() != s2.peek()){
            s1.pop();
            s2.pop();
        }
        return s1.peek();

    }

    public static boolean getNodePath(TreeNode root, TreeNode n, Stack<TreeNode> s){
        s.push(root);
        if(root == n) return true;
        boolean found = false;
        if(root.left != null){
            found = getNodePath(root.left, n, s);
        }
        if(!found && root.right != null){
            found = getNodePath(root.right, n, s);
        }
        if(!found){
            s.pop();
        }
        return found;
    }
}

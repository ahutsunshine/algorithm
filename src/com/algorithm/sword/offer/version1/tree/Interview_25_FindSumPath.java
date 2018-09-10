package com.algorithm.sword.offer.version1.tree;

import java.util.Stack;

public class Interview_25_FindSumPath {
    public static void main(String[] args) {
        Node root = new Node(8);
        Node n1 = new Node(6);
        Node n2 = new Node(10);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        Node n6 = new Node(11);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        findPath(root,19);
    }
    public static void findPath(Node root, int expectedNum) {
        if (root == null) return;
        int curNum = 0;
        Stack<Integer> stack = new Stack<>();
        findPath(root, stack, curNum, expectedNum);
    }

    public static void findPath(Node root, Stack<Integer> stack, int curNum, int expectedNum) {
        if (root == null) return;
        stack.push(root.val);
        curNum += root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && curNum == expectedNum) {
            print(stack);
        }
        if (root.left != null) {
            findPath(root.left, stack, curNum, expectedNum);
        }
        if (root.right != null) {
            findPath(root.right, stack, curNum, expectedNum);
        }
        stack.pop();
    }

    public static void print(Stack<Integer> stack) {
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

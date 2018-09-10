package com.algorithm.sword.offer.version1.tree;

import java.util.Stack;

public class Interview_24_PostOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        postOrder(root);
    }
    public static void postOrder(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node curNode = root, lastVisitedNode =null;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        while (!stack.isEmpty()) {
            curNode = stack.peek();
            if (curNode.right != null && curNode.right != lastVisitedNode) {
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                System.out.print(curNode.val+" ");
                lastVisitedNode = curNode;
                stack.pop();
            }
        }
    }
}

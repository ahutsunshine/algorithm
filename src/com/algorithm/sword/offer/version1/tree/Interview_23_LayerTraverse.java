package com.algorithm.sword.offer.version1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Interview_23_LayerTraverse {
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
        layerTraverse(root);
    }

    public static void layerTraverse(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.val + " ");
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
    }
}

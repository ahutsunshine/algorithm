package com.algorithm.sword.offer.version1.tree;

public class Interview_20_Mirror {
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
        print(root); //转换前中序遍历 5 6 7 8 9 10 11
        mirrorRecursively(root);
        System.out.println();
        print(root); //转换后中序遍历 11 10 9 8 7 6 5
    }

    public static void mirrorRecursively(Node root) {
        if (root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }


    /**
     * 中序遍历
     * @param root
     */
    public static void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }
}

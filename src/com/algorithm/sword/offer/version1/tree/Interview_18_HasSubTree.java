package com.algorithm.sword.offer.version1.tree;

public class Interview_18_HasSubTree {

    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        root1.left = n1;
        root1.right = n2;
        n1.left = n3;
        n1.right = n4;
        System.out.println(hasSubTree(root1, n2));
    }

    /**
     * 遍历root1节点和root2节点相同值,然后比较
     *
     * @param root1
     * @param root2
     */
    public static boolean hasSubTree(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        boolean result = false;
        if (root1.val == root2.val) {
            result = tree1HasTree2(root1, root2);
        }
        if (!result) {
            result = hasSubTree(root1.left, root2);
        }
        if (!result) {
            result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    /**
     * root1和root2拥有相同根值,然后比较左右子树
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean tree1HasTree2(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
    }
}

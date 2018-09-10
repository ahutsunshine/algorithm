package com.algorithm.sword.offer.version1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Interview_39_TreeDepth {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        System.out.println(getTreeDepth(root));
        System.out.println(getTreeDepthWithQueue(root));
    }

    public static int getTreeDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int nLeft = getTreeDepth(root.left);
        int nRight = getTreeDepth(root.right);
        return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
    }

    public static int getTreeDepthWithQueue(Node root) {
        if (root == null) {
            return 0;
        }
        Node cur;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int curNum; //记录本层已经遍历的节点个数
        int eachLayerNum; //记录本层的节点的个数
        int depth = 0; //记录树的深度
        while (!queue.isEmpty()) {
            curNum = 0;
            eachLayerNum = queue.size();
            while (curNum < eachLayerNum) {
                curNum++;
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}


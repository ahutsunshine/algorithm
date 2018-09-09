package com.algorithm._4paradigm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树序列化反序列化
 * 如下一棵二叉树：
 *       1
 *      / \
 *     2   3
 *        / \
 *       4   5
 *        \
 *         6
 * 我们可以依据 层序遍历 得到一个数组（空节点记为 0，最后的空节点略去）
 * [1, 2, 3, 0, 0, 4, 5, 0, 6]
 * 请写一个程序来反序列化,序列化二叉树.
 * 即给定如上的树组，构建出相应的树结构，并再由得到的树结构，构建出如上的数组
 */
public class BinaryTreeSerialization {

    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 由数据转换成树，返回根结点
     * @param array
     * @return
     */
    private static TreeNode deserialization(List<Integer> array) {
        if (array == null || array.isEmpty()) {
            return null;
        }
        Queue<Integer> values = new LinkedList<>(array);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values.poll());
        queue.add(root);
        do {
            TreeNode node = queue.poll();
            Integer left = values.poll();
            Integer right = values.poll();
            if (left != null && left != 0) {
                node.left = new TreeNode(left);
                queue.add(node.left);
            }
            if (right != null && right != 0) {
                node.right = new TreeNode(right);
                queue.add(node.right);
            }
        } while (!values.isEmpty());
        return root;
    }

    /**
     * 由树转换成成数组
     * @param node
     * @return
     */
    private static List<Integer> serialization(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.size() > 0) {
            node = queue.peek();
            if (node.value == 0) {
                list.add(0);
                queue.poll();
                continue;
            }
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null) {
                left = new TreeNode(0);
            }
            if (right == null) {
                right = new TreeNode(0);
            }
            queue.offer(left);
            queue.offer(right);
            list.add(queue.poll().value);
        }
        for (int i = list.size() - 1; list.get(i) == 0; i--) {
            list.remove(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 0, 5, 6};
        List<Integer> input = Arrays.asList(data);
        System.out.println(serialization(deserialization(input)));
    }
}

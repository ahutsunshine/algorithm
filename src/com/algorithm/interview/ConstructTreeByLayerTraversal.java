package com.algorithm.interview;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 通过层次遍历构建二叉树
 * Given array [3,9,20,null,null,15,7] to construct binary tree as below.
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructTreeByLayerTraversal {

    public static void main(String[] args) {
        Integer[] data = {3, 9, 20, null, null, 15, 7};
        ConstructTreeByLayerTraversal t = new ConstructTreeByLayerTraversal();
        TreeNode root = t.construct(data);
        List<Integer> values = t.layerTraversal(root);
        for (Integer val : values) {
            System.out.print(val + " ");
        }

    }

    public TreeNode construct(Integer[] data) {
        if (data == null || data.length == 0) return null;
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        int index;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if ((index = count * 2 - 1) < data.length && data[index] != null) {
                n.left = new TreeNode(data[index]);
                q.offer(n.left);
            }
            if ((index = index + 1) < data.length && data[index] != null) {
                n.right = new TreeNode(data[index]);
                q.offer(n.right);
            }
            count++;
        }
        return root;
    }

    public List<Integer> layerTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        values.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) continue;
                if (n.left != null) {
                    q.offer(n.left);
                    values.add(n.left.val);
                }
                if (n.right != null) {
                    q.offer(n.right);
                    values.add(n.right.val);
                }
            }
        }
        return values;
    }


}

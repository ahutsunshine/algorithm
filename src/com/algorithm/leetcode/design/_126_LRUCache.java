package com.algorithm.leetcode.design;

// 请你设计并实现一个满足LRU (最近最少使用) 缓存 约束的数据结构。
// 实现 LRUCache 类：
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class _126_LRUCache {
    private int capacity;
    private Map<Integer, Node> data;
    private Node head;
    private Node tail;

    public _126_LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node n = data.get(key);
            remove(n);
            addToHeader(n);
            return n.value;
        }
        return -1;
    }

    public void remove(Node n) {
        if (n.pre == null) {
            head = head.next;
        } else {
            n.pre.next = n.next;
        }

        if (n.next == null) {
            tail = n.pre;
        } else {
            n.next.pre = n.pre;
        }
    }

    public void addToHeader(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.pre = null;
            n.next = head;
            head.pre = n;
            head = n;
        }
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            Node n = data.get(key);
            n.value = value;
            remove(n);
            addToHeader(n);
        } else {
            if (data.size() >= capacity) {
                // remove the oldest one
                data.remove(tail.key);
                remove(tail);
            }
            Node n = new Node(key, value);
            addToHeader(n);
            data.put(key, n);
        }
    }

    public static void main(String[] args) {
        _126_LRUCache lRUCache = new _126_LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(2));
        ;    // 返回 1
        lRUCache.put(1, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(2));
    }
}

package com.algorithm.leetcode.design;

// 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
//实现 MyHashMap 类：
//
//MyHashMap() 用空映射初始化对象
//void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
//int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
//void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class _706_HashMap {
    private static int capacity = 1000;
    private LinkedList<Node>[] data;

    class Node {
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public _706_HashMap() {
        data = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (Node n : data[h]) {
            if (n.key == key) {
                n.value = value;
                return;
            }
        }
        data[h].offerFirst(new Node(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        for (Node n : data[h]) {
            if (n.key == key) {
                return n.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        for (Node n : data[h]) {
            if (n.key == key) {
                data[h].remove(n);
                return;
            }
        }
    }

    public static int hash(int key) {
        return key % capacity;
    }
}

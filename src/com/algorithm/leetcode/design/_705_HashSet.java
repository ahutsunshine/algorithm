package com.algorithm.leetcode.design;

// 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
//实现 MyHashSet 类：
//
//void add(key) 向哈希集合中插入值 key 。
//bool contains(key) 返回哈希集合中是否存在这个值 key 。
//void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

import java.util.Iterator;
import java.util.LinkedList;

public class _705_HashSet {
    public static int capacity = 1000;
    private LinkedList<Integer>[] data;

    public _705_HashSet() {
        data = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer data : data[h]) {
            if (data == key) {
                return;
            }
        }
        data[h].addFirst(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer element : data[h]) {
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (Integer data : data[h]) {
            if (data == key) {
                return true;
            }
        }
        return false;
    }

    public static int hash(int key) {
        return key % capacity;
    }

    public static void main(String[] args) {
        _705_HashSet myHashSet = new _705_HashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(3)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
    }
}

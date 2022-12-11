package com.algorithm.leetcode.design;

// 设计实现双端队列。
//
//实现 MyCircularDeque 类:
//
//MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
//boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
//boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
//boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
//boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
//int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
//int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
//boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
//boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
//
public class _641_CircularDeque {
    private Node head;
    private Node tail;
    private int capacity;
    private int count;

    public _641_CircularDeque(int k) {
        this.capacity = k;
        this.count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.next = node;
            node.pre = head;
            head = node;
        }
        this.count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = tail;
            tail.pre = node;
            tail = node;
        }
        this.count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (this.count == 1) {
            head = tail = null;
        } else {
            head = head.pre;
            head.next.pre = null;
            head.next = null;
        }
        this.count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (this.count == 1) {
            head = tail = null;
        } else {
            tail = tail.next;
            tail.pre.next = null;
            tail.pre = null;
        }
        this.count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.value;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public static void main(String[] args) {
        _641_CircularDeque circularDeque = new _641_CircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));                    // 返回 true
        System.out.println(circularDeque.insertLast(2));            // 返回 true
        System.out.println(circularDeque.insertFront(3));                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                        // 返回 true
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                // 返回 true
        System.out.println(circularDeque.getFront());                // 返回 4

    }
}

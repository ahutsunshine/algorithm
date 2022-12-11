package com.algorithm.leetcode.design;

// 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
//
//循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
//
//你的实现应该支持如下操作：
//
//MyCircularQueue(k): 构造器，设置队列长度为 k 。
//Front: 从队首获取元素。如果队列为空，返回 -1 。
//Rear: 获取队尾元素。如果队列为空，返回 -1 。
//enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
//deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
//isEmpty(): 检查循环队列是否为空。
//isFull(): 检查循环队列是否已满。
//
public class _622_CircularQueue {
    private int[] values;
    private int tail;
    private int head;
    private int count;

    public _622_CircularQueue(int k) {
        values = new int[k];
        tail = k - 1;
        head = k - 1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            tail = (tail + values.length - 1) % values.length;
        }
        values[tail] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        count--;
        head = (head + values.length - 1) % values.length;
        if (isEmpty()) {
            head = values.length - 1;
            tail = values.length - 1;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return values[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return values[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == values.length;
    }

    public static void main(String[] args) {
        _622_CircularQueue circularQueue = new _622_CircularQueue(81); // 设置长度为 3
        System.out.println(circularQueue.enQueue(69));// 返回 true
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(92));
        System.out.println(circularQueue.enQueue(12));
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
    }
}

// 使用链表实现
class CircularQueue {
    private Node head;
    private Node tail;
    private int capacity;
    private int count;

    public CircularQueue(int k) {
        this.capacity = k;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node n = new Node(value);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.next = tail;
            tail.pre = n;
            tail = n;
        }
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (count == 1) {
            head = tail = null;
        } else {
            head = head.pre;
            head.next.pre = null;
            head.next = null;
        }
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.value;
    }

    public int Rear() {
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
//        _622_CircularQueue circularQueue = new _622_CircularQueue(81); // 设置长度为 3
//        System.out.println(circularQueue.enQueue(69));// 返回 true
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.enQueue(92));
//        System.out.println(circularQueue.enQueue(12));
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.isFull());
//        System.out.println(circularQueue.isFull());
//        System.out.println(circularQueue.Front());
//        System.out.println(circularQueue.deQueue());

        CircularQueue circularQueue = new CircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1)); // 返回 true
        System.out.println(circularQueue.enQueue(2));// 返回 true
        System.out.println(circularQueue.enQueue(3));// 返回 true
        System.out.println(circularQueue.enQueue(4));// 返回 false，队列已满
        System.out.println(circularQueue.Rear());// 返回 3
        System.out.println(circularQueue.isFull());// 返回 true
        System.out.println(circularQueue.deQueue());// 返回 true
        System.out.println(circularQueue.enQueue(4));// 返回 true
        System.out.println(circularQueue.Rear());// 返回 4
    }
}

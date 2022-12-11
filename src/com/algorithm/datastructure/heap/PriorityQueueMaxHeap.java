package com.algorithm.datastructure.heap;

import java.util.PriorityQueue;

public class PriorityQueueMaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxQueue.add(8);
        maxQueue.add(5);
        maxQueue.add(9);
        maxQueue.add(4);
        maxQueue.add(2);
        maxQueue.add(3);
        maxQueue.add(6);
        maxQueue.add(7);
        maxQueue.add(1);
        while (!maxQueue.isEmpty()) {
            System.out.print(maxQueue.poll());
        }
    }
}

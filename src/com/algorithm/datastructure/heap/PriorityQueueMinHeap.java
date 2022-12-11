package com.algorithm.datastructure.heap;

import java.util.PriorityQueue;

public class PriorityQueueMinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        minQueue.add(8);
        minQueue.add(5);
        minQueue.add(9);
        minQueue.add(4);
        minQueue.add(2);
        minQueue.add(3);
        minQueue.add(6);
        minQueue.add(7);
        minQueue.add(1);
        while (!minQueue.isEmpty()) {
            System.out.print(minQueue.poll());
        }
    }
}

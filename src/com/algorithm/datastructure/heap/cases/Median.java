package com.algorithm.datastructure.heap.cases;

import java.util.PriorityQueue;

public class Median {
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));

    // should match 3 conditions:
    // 1. max heap store N/2 or N/2+1 elements and min heap stores N/2 elements
    // 2. the values in max heap are less than it in min heap
    // 3. the count in max heap should more than it in min heap
    public void add(int value) {
        if (minQueue.size() == maxQueue.size()) {
            minQueue.add(value);
            maxQueue.add(minQueue.poll());
        } else {
            maxQueue.add(value);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.size() == 0 && maxQueue.size() == 0) {
            return Integer.MAX_VALUE;
        }
        if (minQueue.size() == maxQueue.size()) {
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
        if (maxQueue.size() > 0) {
            return maxQueue.peek();
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        Median median = new Median();
        median.add(1);
        median.add(2);
        median.add(3);
        median.add(4);
        median.add(5);
        System.out.println(median.findMedian());
    }
}

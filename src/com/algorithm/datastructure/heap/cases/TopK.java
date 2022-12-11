package com.algorithm.datastructure.heap.cases;

import java.util.PriorityQueue;

public class TopK {
    // get min numbers of the first k
    public int[] topMinK(int[] values, int k) {
        if (k <= 0) {
            return null;
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int value : values) {
            minQueue.add(value);
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        int[] top = new int[minQueue.size()];
        for (int i = 0; i < top.length; i++) {
            top[i] = minQueue.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] values = new int[]{5, 9, 2, 10, 7, 20, 18, 1, 8};
        TopK topK = new TopK();
        int[] top = topK.topMinK(values, 5);
        for (int t : top){
            System.out.print(t + " ");
        }
    }
}

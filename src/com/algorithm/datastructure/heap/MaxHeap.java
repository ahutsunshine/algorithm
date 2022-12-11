package com.algorithm.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private final List<Integer> data;

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }

    private void shiftDown(int index) {
        while (index * 2 + 1 < data.size()) {
            int child = index * 2 + 1;
            int max = child;
            if (child + 1 < data.size() && data.get(child) < data.get(child + 1)) {
                max = child + 1;
            }
            if (data.get(index) >= data.get(max)) {
                break;
            }
            swap(index, max);
            index = max;
        }
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int father = (index - 1) / 2;
            if (data.get(father) >= data.get(index)) {
                break;
            }
            swap(father, index);
            index = father;
        }
    }

    public void push(int value) {
        data.add(value);
        shiftUp(data.size() - 1);
    }

    public int pop() {
        if (data.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int root = data.get(0);
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        shiftDown(0);
        return root;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.push(8);
        heap.push(5);
        heap.push(9);
        heap.push(4);
        heap.push(2);
        heap.push(3);
        heap.push(6);
        heap.push(7);
        heap.push(1);
        // construct max heap: [9, 7, 8, 5, 2, 3, 6, 4, 1]
        while (heap.data.size() > 0) {
            System.out.print(heap.pop());
        }
    }
}

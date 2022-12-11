package com.algorithm.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private final List<Integer> data;

    public MinHeap() {
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
            int min = child;
            if (child + 1 < data.size() && data.get(child) > data.get(child + 1)) {
                min = child + 1;
            }
            if (data.get(min) >= data.get(index)) {
                break;
            }
            swap(min, index);
            index = min;
        }
    }

    private void shiftUp(int index) {
        while (index > 0) {
            // father index is (child - 1) / 2
            int father = (index - 1) / 2;
            if (data.get(father) > data.get(index)) {
                swap(father, index);
                index = father;
            } else {
                break;
            }
        }
    }

    public void push(int value) {
        data.add(value);
        shiftUp(data.size() - 1);
    }

    public int pop() {
        if (data.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int root = data.get(0);
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        shiftDown(0);
        return root;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.push(8);
        heap.push(5);
        heap.push(9);
        heap.push(4);
        heap.push(2);
        heap.push(3);
        heap.push(6);
        heap.push(7);
        heap.push(1);
        // construct min heap: [1, 2, 3, 4, 5, 9, 6, 8, 7]
        while (heap.data.size() > 0) {
            System.out.print(heap.pop());
        }
    }
}

package com.algrithm.sword.offer;

import java.util.*;

import static com.algrithm.sword.offer.Interview_29_QuickSort.partition;

/**
 * @author Kevin Yao
 * Get minimum k numbers
 */
public class Interview_30_LeastKNumber {
    public static void main(String[] args) {
        int[] a = {1, 8, 4, 7, 2, 9, 4, 6, 2, 4};
        List<Integer> output = getLeastKNumbers(a, 7);
        output.forEach(i -> System.out.print(i + " "));

        System.out.println();

        int[] b = {1, 8, 4, 7, 2, 9, 4, 6, 2, 4};
        List<Integer> out = getLeastKNumbersUsingMaxHeap(b, 7);
        out.forEach(i -> System.out.print(i + " "));
    }

    private static List<Integer> getLeastKNumbers(int[] a, int k) {
        List<Integer> output = new ArrayList<>();
        if (a == null || a.length == 0 || a.length < k) {
            return output;
        }
        int start = 0;
        int end = a.length - 1;
        int index = partition(a, start, end);
        while (index != k) {
            if (index < k) {
                start = index + 1;
                index = partition(a, start, end);
            } else {
                end = index - 1;
                index = partition(a, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            output.add(a[i]);
        }
        return output;
    }

    private static List<Integer> getLeastKNumbersUsingMaxHeap(int[] a, int k) {
        List<Integer> output = new ArrayList<>();
        if (a == null || a.length == 0 || a.length < k) {
            return output;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int val : a) {
            if (maxHeap.size() < k) {
                maxHeap.add(val);
            } else if (maxHeap.peek() > val) {
                maxHeap.poll();
                maxHeap.add(val);
            }
        }
        for (int val : maxHeap) {
            output.add(val);
        }
        return output;
    }
}

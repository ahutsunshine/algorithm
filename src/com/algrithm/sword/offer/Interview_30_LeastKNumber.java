package com.algrithm.sword.offer;

import java.util.ArrayList;
import java.util.List;

import static com.algrithm.sword.offer.Interview_29_QuickSort.partition;

/**
 * @author Kevin Yao
 * Get minimum k numbers
 */
public class Interview_30_LeastKNumber {
    public static void main(String[] args){
        int[] a = {1, 8, 4, 7, 2, 9, 4, 6, 2, 4};
        List<Integer> output = getLeastKNumbers(a, 7);
        output.stream().forEach(i -> {
            System.out.print(i + " ");
        });
    }

    static List<Integer> getLeastKNumbers(int[] a,int k) {
        if (a == null || a.length == 0) {
            return null;
        }
        int start=0;
        int end = a.length-1;
        int index = partition(a, start, end);
        while (index != k) {
            if (index < k) {
                start = index+1;
                index = partition(a, start, end);
            }else {
                end = index-1;
                index = partition(a, start, end);
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<k;i++) {
            output.add(a[i]);
        }
        return output;
    }
}

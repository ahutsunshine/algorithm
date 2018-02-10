package com.algorithm.sword.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kevin Yao
 */
public class Interview_33_PrintMinNumber {
    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        System.out.println(printMinNumber(nums));

        int[] nums1 = {21,24,22,5,3,31};
        System.out.println(printMinNumber(nums1));

    }

    private static String printMinNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Integer[] values = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = nums[i];
        }
        Arrays.sort(values, new MyComparator());
        StringBuilder result = new StringBuilder();
        for (int val : values) {
            result.append(val);
        }

        return String.valueOf(result);

    }

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 + "" + o2).compareTo(o2 + "" + o1);
        }
    }
}

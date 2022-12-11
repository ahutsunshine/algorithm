package com.algorithm.leetcode.bit;

// https://leetcode-cn.com/problems/single-number-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-zgi4/
public class TotalHammingDistance {
    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count0 = 0, count1 = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count1++;
                } else {
                    count0++;
                }
            }
            total += count0 * count1;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));

        nums = new int[]{4, 14, 4};
        System.out.println(totalHammingDistance(nums));
    }
}

package com.algorithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_41_2_FindContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence(15);
    }

    private static void findContinuousSequence(int sum) {
        int small = 1;
        int big = 2;
        int middle = sum / 2;
        int curSum = small + big;
        while (small <= middle) {
            if (curSum == sum) {
                print(small, big);
            }
            while (curSum > sum && small <= middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    print(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }

    private static void print(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

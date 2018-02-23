package com.algorithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_46_SumOf1ToN {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumSolution1(n));
    }

    private static int sumSolution1(int n) {
        int sum = n;
        boolean status = (n > 0) && ((sum += sumSolution1(n - 1)) > 0);
        return sum;
    }

}


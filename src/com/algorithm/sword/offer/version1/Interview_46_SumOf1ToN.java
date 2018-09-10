package com.algorithm.sword.offer.version1;

/**
 * @author Kevin Yao
 */
public class Interview_46_SumOf1ToN {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumSolution(n));
    }

    private static int sumSolution(int n) {
        int sum = n;
        boolean status = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }

}


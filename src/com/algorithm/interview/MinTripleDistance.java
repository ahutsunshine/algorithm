package com.algorithm.interview;

/**
 * 已知三个升序整数数组a[l], b[m]和c[n]。请在三个数组中各找一个元素，是的组成的三元组距离最小。三元组的距离定义是：假设a[i]、b[j]和c[k]是一个三元组，那么距离为:
 * Distance = max(|a[ I ] – b[ j ]|, |a[ I ] – c[ k ]|, |b[ j ] – c[ k ]|)
 * <p>
 * 请设计一个求最小三元组距离的最优算法，并分析时间复杂度。
 */
public class MinTripleDistance {

    public static void main(String[] args) {
        MinTripleDistance m = new MinTripleDistance();
        int[] a = {3, 4, 5, 7};
        int[] b = {10, 12, 14, 16, 17};
        int[] c = {20, 21, 23, 24, 37};
        System.out.println(m.minDistance(a, b, c));
    }

    public int minDistance(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null) return -1;
        int minDist = Integer.MAX_VALUE;
        int curDist;
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            curDist = max(Math.abs(a[i] - b[j]), Math.abs(b[j] - c[k]), Math.abs(c[k] - a[i]));
            if (curDist < minDist) minDist = curDist;
            int min = min(a[i], b[j], c[k]);
            if (min == a[i]) i++;
            else if (min == b[j]) j++;
            else k++;
        }
        return minDist;
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

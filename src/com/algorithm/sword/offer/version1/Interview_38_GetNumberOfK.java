package com.algorithm.sword.offer.version1;

/**
 * @author Kevin Yao
 */
public class Interview_38_GetNumberOfK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 3, 4, 5};
        int k = 3;
        System.out.println(getNumberOfK(a, k));
    }

    private static int getNumberOfK(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int firstKIndex = getFirstKPosition(a, k);
        int lastKIndex = getLastKPosition(a, k);
        if (firstKIndex <= -1 || lastKIndex <= -1) {
            return 0;
        }
        return lastKIndex - firstKIndex + 1;

    }

    private static int getFirstKPosition(int[] a, int k) {
        int middle;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            middle = (right + left) / 2;
            if (k == a[middle]) {
                if (middle > 0 && a[middle - 1] == a[middle]) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            } else if (k < a[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private static int getLastKPosition(int[] a, int k) {
        int middle;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            middle = (right + left) / 2;
            if (k == a[middle]) {
                if (middle < a.length - 1 && a[middle + 1] == a[middle]) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            } else if (k < a[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}

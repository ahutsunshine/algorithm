package com.algorithm.sword.offer.version1;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Kevin Yao
 */
public class Interview_29_QuickSort {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 3, 2, 1, 2, 8, 2};
        quickSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));

        System.out.println();

        int[] b = {4, 1, 3, 9, 6, 2, 7, 5, 2, 4, 1};
        randomQuickSort(b, 0, b.length - 1);
        Arrays.stream(b).forEach(i -> System.out.print(i + " "));
    }

    static void quickSort(int[] a, int left, int right) {
        if (a == null || a.length == 0) {
            return;
        }
        if (left < right) {
            int index = partition(a, left, right);
            quickSort(a, left, index - 1);
            quickSort(a, index + 1, right);
        }
    }

    static void randomQuickSort(int[] a, int left, int right) {
        if (a == null || a.length == 0) {
            return;
        }
        if (left < right) {
            int index = randomPartition(a, left, right);
            randomQuickSort(a, left, index - 1);
            randomQuickSort(a, index + 1, right);
        }
    }

    static int partition(int[] a, int left, int right) {
        int x = a[left];
        while (left < right) {
            //need to add equal sign,or may cause dead cycle
            while (left < right && a[right] >= x) {
                right--;
            }
            if (left < right) {
                a[left++] = a[right];
            }
            while (left < right && a[left] < x) {
                left++;
            }
            if (left < right) {
                a[right--] = a[left];
            }
        }
        a[left] = x;
        return left;
    }

    static int partition1(int[] a, int left, int right) {
        int x = a[left];
        while (left < right) {
            //need to add equal sign,or may cause dead cycle
            while (left < right && a[right] >= x) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] < x) {
                left++;
            }
            a[right] = a[left];
        }
        a[right] = x;
        return right;
    }

    static int randomPartition(int[] a, int left, int right) {
        int randomIndex = random(left, right);
        swap(a, left, randomIndex);
        return partition(a, left, right);
    }

    static int random(int left, int right) {
        return new Random().nextInt(right - left) + left;
    }

    static void swap(int[] a, int source, int target) {
        int temp = a[source];
        a[source] = a[target];
        a[target] = temp;
    }

}

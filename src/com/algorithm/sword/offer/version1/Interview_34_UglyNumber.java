package com.algorithm.sword.offer.version1;

/**
 * @author Kevin Yao
 */
public class Interview_34_UglyNumber {
    public static void main(String[] args) {
        int index1 = 5;
        System.out.println(getUglyNumber(index1));

        int index2 = 10;
        System.out.println(getUglyNumber(index2));

        int index3 = 1500;
        System.out.println(getUglyNumber(index3));
    }

    private static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNum = new int[index];
        int uglyIndex = 1;
        int pIndex2 = 0, pIndex3 = 0, pIndex5 = 0;
        uglyNum[0] = 1;
        while (uglyIndex < index) {
            int min = getMin(uglyNum[pIndex2] * 2, uglyNum[pIndex3] * 3, uglyNum[pIndex5] * 5);
            uglyNum[uglyIndex] = min;
            while (uglyNum[pIndex2] * 2 <= min) {
                pIndex2++;
            }
            while (uglyNum[pIndex3] * 3 <= min) {
                pIndex3++;
            }
            while (uglyNum[pIndex5] * 5 <= min) {
                pIndex5++;
            }
            uglyIndex++;
        }
        return uglyNum[index - 1];
    }

    private static int getMin(int a, int b, int c) {
        return a < b ? a : (b < c ? b : c);
    }

}

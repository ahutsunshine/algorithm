package com.algorithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_39_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] values = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] nums = findNumsAppearOnce(values);
        System.out.println(nums[0] + " " + nums[1]);
    }

    private static int[] findNumsAppearOnce(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        int[] nums = new int[2];
        int result = 0;
        for (int val : values) {
            result ^= val;
        }
        int indexBit = findFirstBit1(result);
        int bit = 1;
        int num1 = 0, num2 = 0;
        // only the indexBit bit is 1,else 0
        bit <<= indexBit;
        for (int val : values) {
            if ((val & bit) == 0) {
                num1 ^= val;
            } else {
                num2 ^= val;
            }
        }
        nums[0] = num1;
        nums[1] = num2;
        return nums;
    }

    private static int findFirstBit1(int value) {
        int indexBit = 0;
        while (indexBit < 32 && (value & 1) == 0) {
            value >>= 1;
            indexBit++;
        }
        return indexBit;
    }

}

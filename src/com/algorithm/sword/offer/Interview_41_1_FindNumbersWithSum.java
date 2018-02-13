package com.algorithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_41_1_FindNumbersWithSum {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 5, 8, 9,};
        int[] result = findNumbersWithSum(values, 8);
        assert result != null;
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] findNumbersWithSum(int[] values, int sum) {
        if (values == null || values.length == 0) {
            return null;
        }
        int[] result = new int[2];
        int left = 0;
        int right = values.length - 1;
        while (left < right) {
            int curSum = values[left] + values[right];
            if (curSum == sum) {
                result[0] = values[left];
                result[1] = values[right];
                return result;
            } else if (curSum > sum) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}

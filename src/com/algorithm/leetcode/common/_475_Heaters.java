package com.algorithm.leetcode.common;

import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to
 * design a standard heater with fixed warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately,
 * and your expected output will be the minimum radius standard of heaters.
 *
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 *
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class _475_Heaters {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        assert findRadius(houses, heaters) == 1;
    }

    public static int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null || houses.length == 0 || heaters.length == 0) return 0;
        Arrays.sort(heaters);
        int gapMax = 0;
        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index >= heaters.length) {
                gapMax = Math.max(houses[i] - heaters[index - 1], gapMax);
            } else if (index == 0) {
                gapMax = Math.max(heaters[index] - houses[i], gapMax);
            } else {
                int n = Math.min(heaters[index] - houses[i], houses[i] - heaters[index - 1]);
                gapMax = Math.max(n, gapMax);
            }
        }
        return gapMax;
    }
}

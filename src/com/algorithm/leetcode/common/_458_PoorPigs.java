package com.algorithm.leetcode.common;

import java.util.List;

/**
 * There are 1000 buckets, one and only one of them contains poison,
 * the rest are filled with water. They all look the same.
 * If a pig drinks that poison it will die within 15 minutes.
 * What is the minimum amount of pigs you need to figure out
 * which bucket contains the poison within one hour.
 *
 * Answer this question, and write an algorithm for the follow-up general case.
 * Follow-up:
 *
 * If there are n buckets and a pig drinking poison will die within m minutes,
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes?
 * There is exact one bucket with poison.
 * Reference: https://www.cnblogs.com/grandyang/p/7664088.html
 * */
public class _458_PoorPigs {
    public static void main(String[] args) {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        assert poorPigs1(buckets, minutesToDie, minutesToTest) == 5;
        assert poorPigs2(buckets, minutesToDie, minutesToTest) == 5;

        buckets = 1;
        minutesToDie = 1;
        minutesToTest = 1;
        assert poorPigs1(buckets, minutesToDie, minutesToTest) == 0;
        assert poorPigs2(buckets, minutesToDie, minutesToTest) == 0;
    }

    public static int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }

    public static int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets == 1) return 0;
        int count = 1;
        long base = minutesToTest / minutesToDie + 1, m = base;
        while(m < buckets){
            count++;
            m *= base;
        }
        return count;
    }
}

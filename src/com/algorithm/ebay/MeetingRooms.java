package com.algorithm.ebay;

import java.util.Scanner;

public class MeetingRooms {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String meeting = in.nextLine();
            String[] times = meeting.split(" ");
            nums[i][0] = Integer.parseInt(times[0]);
            nums[i][1] = Integer.parseInt(times[1]);
        }

        int[] slots = new int[24];
        int max = Integer.MIN_VALUE;
        for (int[] num : nums) {
            max = minAvailableMeetingRooms(slots, max, num[0], num[1]);
        }
        System.out.println(max);
    }

    public static int minAvailableMeetingRooms(int[] slots, int max, int left, int right) {
        for (int i = left; i < right; i++) {
            int val = ++slots[i];
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}

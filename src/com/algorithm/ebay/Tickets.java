package com.algorithm.ebay;

import java.util.Scanner;

public class Tickets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 0) {
            System.out.println(false);
            return;
        }
        int[][] nums = new int[n][3];
        in.nextLine();
        boolean invalid = false;
        for (int i = 0; i < n; i++) {
            try {
                String meeting = in.nextLine();
                String[] times = meeting.split(" ");
                nums[i][0] = Integer.parseInt(times[0]);
                if (nums[i][0] <= 0) {
                    invalid = true;
                } else if (nums[i][0] > 4000) {
                    invalid = true;
                }
                nums[i][1] = Integer.parseInt(times[1]);
                if (nums[i][1] < 0) {
                    invalid = true;
                } else if (nums[i][1] > 63) {
                    invalid = true;
                }
                nums[i][2] = Integer.parseInt(times[2]);
                if (nums[i][2] < 0) {
                    invalid = true;
                } else if (nums[i][2] > 63) {
                    invalid = true;
                }
            } catch (Exception e) {
                invalid = true;
            }
        }
        if (invalid) {
            System.out.println(false);
            return;
        }

        int[] tickets = new int[64];
        for (int[] num : nums) {
            if (!satisfyTicketRequirements(tickets, num[0], num[1], num[2])) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static boolean satisfyTicketRequirements(int[] station, int tickets, int start, int end) {
        if (start >= end) {
            return false;
        }
        for (int i = start; i < end && i < station.length; i++) {
            station[i] = station[i] + tickets;
            if (station[i] > 4000) {
                return false;
            }
        }
        return true;
    }
}

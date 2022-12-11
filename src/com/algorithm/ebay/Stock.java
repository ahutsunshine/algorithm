package com.algorithm.ebay;

import java.util.Scanner;

public class Stock {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] stocks = in.nextLine().split(" ");
        int[] nums = new int[stocks.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stocks[i]);
        }
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        if (length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }

        int[] sell = new int[length];
        int[] buy = new int[length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        buy[2] = Math.max(buy[1], -prices[2]);
        sell[2] = Math.max(sell[1], buy[1] + prices[2]);

        if (length <= 3) {
            return sell[2];
        }

        for (int i = 3; i < length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 3] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[length - 1];
    }
}

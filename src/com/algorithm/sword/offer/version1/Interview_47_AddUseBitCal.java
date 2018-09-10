package com.algorithm.sword.offer.version1;

public class Interview_47_AddUseBitCal {
    public static void main(String[] args) {
        int num1 = 19, num2 = 29;
        System.out.println(add(num1, num2));
    }

    private static int add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}

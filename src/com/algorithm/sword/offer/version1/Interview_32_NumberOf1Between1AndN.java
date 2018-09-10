package com.algorithm.sword.offer.version1;

/**
 * @author Kevin Yao
 */
public class Interview_32_NumberOf1Between1AndN {
    public static void main(String[] args) {
        int n = 1000;
        int result1 = numberOf1Between1AndN_String(n);
        int result2 = numberOf1Between1AndN(n);

        assert result1 == result2;
        System.out.println(result1);


    }

    private static int numberOf1Between1AndN(int n) {
        int base = 1;
        int round = n;
        int count = 0;
        int weight;
        while (round > 0) {
            weight = round % 10;
            round /= 10;
            if (weight == 0) {
                count += round * base;
            } else if (weight == 1) {
                count += round * base + (n % base) + 1;
            } else {
                count += round * base + base;
            }
        }
        return count;
    }

    private static int numberOf1Between1AndN_String(int n) {
        int count = 0;
        while (n > 0) {
            count += NumberOf1_String(n);
            n--;
        }
        return count;
    }

    private static int NumberOf1_String(int n) {
        int count = 0;
        String num = String.valueOf(n);
        char[] str = num.toCharArray();
        for (char c : str) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    private static int NumberOf1_Int(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}

package com.algorithm.bank;

import java.util.Scanner;

/**
 * @author Kevin Yao
 * 描述：在抽象代数中，我们学过一个关于有限域的定理：存在一个大小为a的有限域当且仅当q是某个素数的方幂，
 * 即q=p的k次方，k>=1,且在同构意义下，相同大小的有限域只有一个。对于一个给定输入n，你需要计算有多少个不同构的
 * 有限域，阿门的大小是不超过n的。
 * 输入样例：输入37 输出19
 * 2，3，4，5，7，8，9，11，13，16，17，19，23，25，27，29，31，32，37
 *
 */
public class LimitedBundary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int count = 0;
        for (int i = 2; i <= m; i++) {
            //判断素数
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                int res = i;
                while (true) {
                    if (res * i <= m) {
                        res = res * i;
                        count++;
                    } else {
                        break;
                    }
                }
            }

        }
        System.out.println(count);
    }
}

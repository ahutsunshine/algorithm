package com.algorithm.leetcode.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 根据 逆波兰表示法，求表达式的值。
//
//有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
public class _150_ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                    int a = s.pop();
                    int b = s.pop();
                    s.push(a + b);
                    break;
                case "-":
                    a = s.pop();
                    b = s.pop();
                    s.push(b - a);
                    break;
                case "*":
                    a = s.pop();
                    b = s.pop();
                    s.push(a * b);
                    break;
                case "/":
                    a = s.pop();
                    b = s.pop();
                    s.push(b / a);
                    break;
                default:
                    s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}

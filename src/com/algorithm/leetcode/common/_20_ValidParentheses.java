package com.algorithm.leetcode.common;

import java.util.*;

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//
public class _20_ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> m = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');

            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (m.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != m.get(s.charAt(i))) return false;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));

        s = "()[]{}";
        System.out.println(isValid(s));

        s = "([)]";
        System.out.println(isValid(s));

        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.peek();
        deque.poll();
        deque.pop();
    }
}

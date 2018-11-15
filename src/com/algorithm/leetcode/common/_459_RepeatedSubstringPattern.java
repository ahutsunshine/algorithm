package com.algorithm.leetcode.common;

/**
 *Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class _459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abab";
        assert repeatedSubstringPattern1(s);
        assert repeatedSubstringPattern2(s);

        s = "aba";
        assert !repeatedSubstringPattern1(s);
        assert !repeatedSubstringPattern2(s);
    }

    public static boolean repeatedSubstringPattern1(String s) {
        if (s == null) return false;
        for (int i = s.length() / 2; i >= 1; i--) {
            if (s.length() % i == 0) {
                int count = s.length() / i;
                StringBuilder sb = new StringBuilder();
                String sub = s.substring(0, i);
                for (int j = 0; j < count; j++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        if (s == null) return false;
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}

package com.algorithm.leetcode.common;

/**
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */

public class _434_NumberOfSegmentsInString {
    public static void main(String[] args){
        assert countSegments1("Hello, my name is John") == 5;
        assert countSegments2("Hello, my name is John") == 5;
        assert countSegments3("Hello, my name is John") == 5;
    }

    public static int countSegments1(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        boolean mark = true;
        s = s.trim();
        for(int i = s.length() - 1;i >= 0;i--){
            if(mark && s.charAt(i) != ' '){
                count ++;
                mark = false;
            }else if(s.charAt(i) == ' '){
                mark = true;
            }
        }
        return count;
    }

    public static int countSegments2(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) count++;
        }

        return count;
    }

    public static int countSegments3(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
}

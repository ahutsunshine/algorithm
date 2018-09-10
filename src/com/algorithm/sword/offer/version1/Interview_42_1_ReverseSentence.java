package com.algorithm.sword.offer.version1;

/**
 * @author Kevin Yao
 */
public class Interview_42_1_ReverseSentence {
    public static void main(String[] args) {
        String s = "I am a student.";
        String result1 = reverseSentence(s);
        String result2 = reverseSentenceChar(s);

        assert result1.equals(result2);
        System.out.println(result1);

    }

    private static String reverseSentence(String str) {
        if (str == null) {
            return null;
        }
        str = reverse(str);
        String[] words = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(reverse(word)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String reverseSentenceChar(String str) {
        if (str == null) {
            return null;
        }
        char[] reverse = reverseChar(str.toCharArray(), 0, str.length() - 1);
        int start = 0, end = 0;
        while (start < str.length()) {
            if (reverse[start] == ' ') {
                start++;
                end++;
            } else if (end == ' ' || end == str.length()) {
                reverseChar(reverse, start, end - 1);
                start = ++end;
            } else {
                end++;
            }
        }
        return new String(reverse);
    }

    private static String reverse(String str) {
        return String.valueOf(new StringBuffer(str).reverse());
    }

    private static char[] reverseChar(char[] values, int start, int end) {
        if (values == null) {
            return null;
        }
        while (start < end) {
            char tmp = values[start];
            values[start] = values[end];
            values[end] = tmp;
            start++;
            end--;
        }
        return values;
    }
}

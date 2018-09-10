package com.algorithm.sword.offer.version1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin Yao
 */
public class Interview_35_FirstNotRepeatChar {
    public static void main(String[] args) {
        String str = "ewrrwets!@$%*(*(^@!^%&@%HFHDHDRKL:J::~+_)";
        char c1 = getFirstNotRepeatChar(str);
        char c2 = getFirstNotRepeatCharUsingMap(str);

        assert c1 == c2;
        System.out.println(c1);

    }

    private static char getFirstNotRepeatChar(String str) {
        if (str == null) {
            return '\0';
        }
        char[] keys = str.toCharArray();
        int[] hash = new int[6400];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = 0;
        }
        for (char key : keys) {
            hash[key]++;
        }
        for (char key : keys) {
            if (hash[key] == 1) {
                return key;
            }
        }
        return '\0';
    }

    private static char getFirstNotRepeatCharUsingMap(String str) {
        if (str == null) {
            return '\0';
        }
        Map<Character, Integer> hash = new HashMap<>();
        char[] keys = str.toCharArray();
        for (char key : keys) {
            Integer count = hash.get(key);
            if (count == null) {
                hash.put(key, 1);
            } else {
                hash.put(key, ++count);
            }
        }
        for (char key : keys) {
            if (hash.get(key) == 1) {
                return key;
            }
        }
        return '\0';
    }
}

package com.algorithm.sword.offer;

/**
 * @author Kevin Yao
 */
public class Interview_35_FirstNotRepeatChar {
    public static void main(String[] args) {
        String str ="`ewrrwets!@$%*(*(^@!^%&@%HFHDHDRKL:J::~+_)";
        System.out.println(getFirstNotRepeatChar(str));
    }

    private static char getFirstNotRepeatChar(String str){
        if (str == null) {
            return '\0';
        }
        char[] keys = str.toCharArray();
        int[] hash = new int[6400];
        for (int i=0;i<hash.length;i++) {
            hash[i] = 0;
        }
        for (char key:keys) {
            hash[key]++;
        }
        for (char key : keys) {
            if (hash[key] == 1) {
                return key;
            }
        }
        return '\0';
    }
}

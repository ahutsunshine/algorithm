package com.algorithm.leetcode.design;

// Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//
//请你实现 Trie 类：
//
//Trie() 初始化前缀树对象。
//void insert(String word) 向前缀树中插入字符串 word 。
//boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

public class _208_Trie {
    private boolean isEnd;
    private _208_Trie[] children;

    public _208_Trie() {
        isEnd = false;
        children = new _208_Trie[26];
    }

    public void insert(String word) {
        _208_Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) {
                t.children[index] = new _208_Trie();
            }
            t = t.children[index];
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        _208_Trie t = searchPrefix(word);
        return t != null && t.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private _208_Trie searchPrefix(String prefix) {
        _208_Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (t.children[index] == null) {
                return null;
            }
            t = t.children[index];
        }
        return t;
    }

    public static void main(String[] args) {
        _208_Trie trie = new _208_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        ;   // 返回 True
        System.out.println(trie.search("app"));
        ;     // 返回 False
        System.out.println(trie.startsWith("app"));
        ; // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));
        ;     // 返回 True


    }
}

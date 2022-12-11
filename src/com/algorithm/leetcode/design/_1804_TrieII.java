package com.algorithm.leetcode.design;

// 前缀树（trie ，发音为 "try"）是一个树状的数据结构，用于高效地存储和检索一系列字符串的前缀。前缀树有许多应用，如自动补全和拼写检查。
//
//实现前缀树 Trie 类：
//
//Trie() 初始化前缀树对象。
//void insert(String word) 将字符串 word 插入前缀树中。
//int countWordsEqualTo(String word) 返回前缀树中字符串 word 的实例个数。
//int countWordsStartingWith(String prefix) 返回前缀树中以 prefix 为前缀的字符串个数。
//void erase(String word) 从前缀树中移除字符串 word 。
public class _1804_TrieII {
    private _1804_TrieII[] children;
    // 表示以该节点结尾的字符串个数
    private int count;
    // 表示以该节点作为前缀节点的字符串个数
    private int preCount;

    public _1804_TrieII() {
        children = new _1804_TrieII[26];
        count = 0;
        preCount = 0;
    }

    public void insert(String word) {
        _1804_TrieII t = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) {
                t.children[index] = new _1804_TrieII();
            }
            t.preCount++;
            t = t.children[index];
        }
        t.count++;
    }

    public boolean search(String word) {
        _1804_TrieII t = searchPrefix(word);
        return t != null && t.count > 0;
    }

    public int countWordsEqualTo(String word) {
        _1804_TrieII t = searchPrefix(word);
        return t == null ? 0 : t.count;
    }

    public int countWordsStartingWith(String prefix) {
        _1804_TrieII t = searchPrefix(prefix);
        return t == null ? 0 : t.preCount;
    }

    public void erase(String word) {
        // 检查单词是否可以查询到，如果不能，则是非法单词
        if (!search(word)) {
            return;
        }

        _1804_TrieII t = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) {
                return;
            } else if (--t.children[index].preCount == 0) {
                t.children[index] = null;
                return;
            }
            t = t.children[index];
        }
        t.count--;
    }

    private _1804_TrieII searchPrefix(String prefix) {
        _1804_TrieII t = this;
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
        _1804_TrieII trie = new _1804_TrieII();
        trie.insert("apple");               // 插入 "apple"。
        trie.insert("apple");               // 插入另一个 "apple"。
        System.out.println(trie.countWordsEqualTo("apple"));;    // 有两个 "apple" 实例，所以返回 2。
        System.out.println(trie.countWordsStartingWith("app"));; // "app" 是 "apple" 的前缀，所以返回 2。
        trie.erase("apple");                // 移除一个 "apple"。
        System.out.println(trie.countWordsEqualTo("apple"));;    // 现在只有一个 "apple" 实例，所以返回 1。
        System.out.println(trie.countWordsStartingWith("app"));; // 返回 1
        trie.erase("apple");                // 移除 "apple"。现在前缀树是空的。
        System.out.println(trie.countWordsStartingWith("app"));; // 返回 0
    }
}

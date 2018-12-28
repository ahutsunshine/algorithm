package com.algorithm.leetcode.tree;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class _208_TrieWithArray {
    TrieNodeWithArray root;

    public _208_TrieWithArray() {
        root = new TrieNodeWithArray(' ');
    }
    public void insert(String word) {
        if (word == null) return;
        TrieNodeWithArray n = root;
        for (char c : word.toCharArray()) {
            if (n.children[c - 'a'] == null) {
                n.children[c - 'a'] = new TrieNodeWithArray(c);
            }
            n = n.children[c - 'a'];
        }
        n.isWord = true;
    }

    public boolean search(String word) {
        if (word == null) return false;
        TrieNodeWithArray n = root;
        for (char c : word.toCharArray()) {
            if (n.children[c - 'a'] == null) {
                return false;
            }
            n = n.children[c - 'a'];
        }
        return n.isWord;
    }

    public boolean startsWith(String prefix) {
        if(prefix == null) return false;
        TrieNodeWithArray n = root;
        for (char c : prefix.toCharArray()) {
            if (n.children[c - 'a'] == null) {
                return false;
            }
            n = n.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        _208_TrieWithArray trie = new _208_TrieWithArray();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

class TrieNodeWithArray {
    char val;
    boolean isWord = false;
    TrieNodeWithArray[] children = new TrieNodeWithArray[26];

    public TrieNodeWithArray(char c) {
        val = c;
    }
}

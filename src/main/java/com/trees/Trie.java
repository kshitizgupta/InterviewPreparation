package com.trees;

import java.util.HashMap;

public class Trie {
    private final TrieNode root;

    private class TrieNode {
        HashMap<Character, TrieNode> map;
        boolean isEnd;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        insertRecur(word, 0, root);
    }

    private void insertRecur(String word, int currIndex, TrieNode currNode) {
        if (currIndex == word.length()) {
            currNode.isEnd = true;
            return;
        }

        //If the current node does not have the current character, then put it in there and add a new node
        if (!currNode.map.containsKey(word.charAt(currIndex))) {
            currNode.map.put(word.charAt(currIndex), new TrieNode());
        }

        insertRecur(word, currIndex + 1, currNode.map.get(word.charAt(currIndex)));
    }

    public boolean search(String word) {
        return searchRecur(word, 0, root);
    }

    private boolean searchRecur(String word, int currIndex, TrieNode currNode) {
        if (currIndex == word.length()) {
            return currNode.isEnd;
        }

        // If current node's hash map doesnt contain the current character, then it means that
        // the word doesnt exist
        if (!currNode.map.containsKey(word.charAt(currIndex))) {
            return false;
        }

        if (currIndex == word.length() - 1) {
            if (currNode.isEnd) return true;
        }

        return searchRecur(word, currIndex + 1, currNode.map.get(word.charAt(currIndex)));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insertWord("abc");
        trie.insertWord("qwe");
        trie.insertWord("abd");

        System.out.println("should be true = " + trie.search("abc"));
        System.out.println("should be false = " + trie.search("abcd"));
        System.out.println("should be true = " + trie.search("qwe"));
        System.out.println("should be true = " + trie.search("abd"));
        System.out.println("should be false = " + trie.search("ab"));
        System.out.println("should be false = " + trie.search("a"));
        System.out.println("should be false = " + trie.search("xyz"));
    }
}


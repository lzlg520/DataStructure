package com.rennixue.trie;

import java.util.Stack;
import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {
    /**
     * 内部节点类
     */
    private class Node {
        // 标记是否是单词
        private boolean isWord;
        // 存储下个节点的信息
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isWord=" + isWord +
                    ", next=" + next +
                    '}';
        }
    }

    // 根节点
    private Node root;
    // 节点数
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加单词
     *
     * @param word
     */
    public void add(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }
        if (!curr.isWord) {
            curr.isWord = true;
            size++;
        }
    }

    /**
     * 查询Trie中是否包含该单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return curr.isWord;
    }

    /**
     * 判断是否有前缀为prefix的前缀
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.next.get(c) == null) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return true;
    }

    /**
     * 删除单词
     *
     * @param word
     */
    public void delete(String word) {
        if (!contains(word)) {
            return;
        }
        Stack<Node> preNodes = new Stack<>();
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            preNodes.push(curr);
            curr = curr.next.get(c);
        }

        if (curr.next.size() == 0) {
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                Node pre = preNodes.pop();
                if ((i != word.length() - 1 && pre.next.get(c).isWord) || pre.next.get(c).next.size() != 0) {
                    break;
                }
                pre.next.remove(c);
            }
        } else {
            curr.isWord = false;
        }
        size--;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}

package com.rennixue.trie;

import org.junit.Test;

public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        trie.add("work");
        System.out.println(trie);

        System.out.println(trie.contains("hello"));

        System.out.println(trie.isPrefix("wor"));

        trie.delete("work");
        System.out.println(trie);
    }
}

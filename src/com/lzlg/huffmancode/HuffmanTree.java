package com.lzlg.huffmancode;

/**
 * 霍夫曼树
 */
public class HuffmanTree {
    Node root;

    public HuffmanTree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树，不能遍历");
        }
    }
}

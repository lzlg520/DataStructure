package com.lzlg.huffmancode;

/**
 * 节点对象
 */
public class Node implements Comparable<Node> {
    Byte data; // 节点存储的字节数据
    Integer weight; // 权重，对于data数据出现的次数

    Node left;
    Node right;

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public Node(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}

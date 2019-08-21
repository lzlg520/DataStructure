package com.lzlg.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 霍夫曼树：树的带权路径长度达到最小的二叉树
 * 几个概念：
 * 路径：从root节点到子节点之间的通路就是路径 n
 * 路径长度：从root节点到字节的之间走过的路数就是路径长度 = n（路径） - 1
 * 带权：节点有属性weight该数值表示权重
 * 带权路径长度：节点的weight属性 乘以 节点的路径长度 就是节点的带权路径长度
 * 树的带权路径长度：树的叶子节点（注意是叶子节点，不是子节点）带权路径长度之和
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree tree = toHuffmanTree(array);
        tree.preOrder();
    }

    /**
     * 将数组转换成霍夫曼树：
     * 1.对数组上的元素进行排序（转换成ArrayList）
     * 2.取出数组元素的第一个元素和第二个元素，将两个元素的值相加形成父节点，然后形成子树
     * 3.从ArrayList中删除这已经形成子树的两个元素，并将父节点的值加入
     * 4.重复1，2，3过程，直到ArrayList里的元素只剩一个（就是根元素）
     *
     * @param array
     * @return
     */
    private static HuffmanTree toHuffmanTree(int[] array) {
        List<HuffmanNode> list = Arrays.stream(array).boxed()
                .map(HuffmanNode::new).collect(Collectors.toList());

        while (list.size() > 1) {
            // 1.先排序
            Collections.sort(list);
            // 2.取出第一个和第二个元素
            HuffmanNode leftNode = list.get(0);
            HuffmanNode rightNode = list.get(1);
            // 3.构造父节点
            HuffmanNode parentNode = new HuffmanNode(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            // 4.移出前两个节点，并添加父节点到list中
            list.remove(leftNode);
            list.remove(rightNode);

            list.add(parentNode);

        }
        // 返回霍夫曼树
        return new HuffmanTree(list.get(0));
    }
}

class HuffmanTree {
    HuffmanNode root;

    public HuffmanTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树，不能遍历");
        }
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    int value;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

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
}
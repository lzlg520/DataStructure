package com.lzlg.huffmancode;

import java.util.*;

/**
 * 霍夫曼树工具类
 */
public class HuffmanTreeUtil {
    private HuffmanTreeUtil() {
    }

    public static HuffmanTree toHuffmanTree(byte[] bytes) {
        // 统计字节出现次数
        Map<Byte, Integer> countMap = countByte(bytes);
        // 遍历countMap，创建所有的Node节点
        List<Node> nodes = toNodeList(countMap);
        // 构建霍夫曼树
        return toHuffmanTree(nodes);
    }

    /**
     * 将统计好的字节次数数据集合转换为Node节点列表
     *
     * @param countMap
     * @return
     */
    private static List<Node> toNodeList(Map<Byte, Integer> countMap) {
        // 遍历countMap，创建所有的Node节点
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : countMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 统计byte字节数组中字节数据出现的次数
     *
     * @param bytes
     * @return
     */
    private static Map<Byte, Integer> countByte(byte[] bytes) {
        Map<Byte, Integer> countMap = new HashMap<>();
        for (byte b : bytes) {
            Integer count = countMap.get(b);
            if (count == null) {
                countMap.put(b, 1);
            } else {
                countMap.put(b, count + 1);
            }
        }
        return countMap;
    }

    /**
     * 将节点列表转换为霍夫曼树
     *
     * @param nodes
     * @return
     */
    private static HuffmanTree toHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 1.排序
            Collections.sort(nodes);
            // 2.取出第一个和第二个元素
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 注意父节点是没有data数据的
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            // 3.删除第一个和第二个元素，并添加父元素
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }

        return new HuffmanTree(nodes.get(0));
    }
}

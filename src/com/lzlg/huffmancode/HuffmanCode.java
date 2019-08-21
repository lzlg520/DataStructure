package com.lzlg.huffmancode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 霍夫曼编码，用于存储编码数据，编码方法，解码方法
 */
public class HuffmanCode {
    /**
     * 用于解压缩的构造方法重载
     *
     * @param afterCodeBytes
     * @param huffmanCodeMap
     */
    public HuffmanCode(byte[] afterCodeBytes, Map<Byte, String> huffmanCodeMap) {
        this.afterCodeBytes = afterCodeBytes;
        this.huffmanCodeMap = huffmanCodeMap;
    }

    public HuffmanCode(String content) {
        byte[] bytes = content.getBytes();
        // 1.转换为霍夫曼树
        HuffmanTree tree = HuffmanTreeUtil.toHuffmanTree(bytes);
        // 2.将霍夫曼树的路径信息存储在编码对照Map集合中
        this.storeRouteToMap(tree);
        // 3.根据编码信息对照表，将原字节数组转换为编码后的字符串
        String afterCode = this.toStringByCodeMap(bytes);
        // 4.将编码后的字符串压缩成字节数组
        afterCodeBytes = toZipByteArray(afterCode);
    }

    /**
     * 构造方法重载
     *
     * @param bytes
     */
    public HuffmanCode(byte[] bytes) {
        // 1.转换为霍夫曼树
        HuffmanTree tree = HuffmanTreeUtil.toHuffmanTree(bytes);
        // 2.将霍夫曼树的路径信息存储在编码对照Map集合中
        this.storeRouteToMap(tree);
        // 3.根据编码信息对照表，将原字节数组转换为编码后的字符串
        String afterCode = this.toStringByCodeMap(bytes);
        // 4.将编码后的字符串压缩成字节数组
        afterCodeBytes = toZipByteArray(afterCode);
    }

    /**
     * 用于存储编码后的字节数组
     */
    private byte[] afterCodeBytes;
    /**
     * 用于拼接路径编码
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * 用于存储编码对照表数据
     */
    private Map<Byte, String> huffmanCodeMap = new HashMap<>();
    /**
     * 用于解码使用的对照表数据，和huffmanCodeMap数据对应
     */
    private Map<String, Byte> huffmanDecodeMap = new HashMap<>();

    /**
     * 解码方法：
     * 1.将编码后的byte数组，转换为二进制字符串
     * 2.根据解码对照表解码成相应的byte
     */
    public byte[] decode() {
        // 1.获取解码对照表数据
        getDecodeMap();
        // 2.将编码后的byte数组转换为二进制字符串
        StringBuilder sb = new StringBuilder();
        int byteArrayLen = afterCodeBytes.length;
        for (int i = 0; i < byteArrayLen; i++) {
            sb.append(byteToString(i != byteArrayLen - 1, afterCodeBytes[i]));
        }
        // 3.根据解码对照表进行解码
        List<Byte> byteList = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1; // 用于记录移动量
            while (true) {
                String str = sb.substring(i, i + count);
                if (huffmanDecodeMap.get(str) == null) {// 如果从解码对照表中取不出数据，
                    // 让count++，再次截取多一位的字符串，再次比较
                    count++;
                } else {// 能够取出数据，则退出循环
                    byteList.add(huffmanDecodeMap.get(str));
                    i += count;
                    break;
                }
            }
        }
        // 4.将list转换成byte数组
        int size = byteList.size();
        byte[] decodeBytes = new byte[size];
        for (int i = 0; i < size; i++) {
            decodeBytes[i] = byteList.get(i);
        }
        return decodeBytes;
    }

    /**
     * 将字节数据转换为二进制字符串
     *
     * @param flag 判断是否补高位，最后一位无需补高位
     * @param b    要转换的字节数据
     * @return
     */
    private String byteToString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256; // 进行补位
        }
        String string = Integer.toBinaryString(temp);// 返回的是temp对应的二进制的补码
        if (flag) {
            return string.substring(string.length() - 8);
        } else {
            return string;
        }
    }

    /**
     * 给解码数据对照表Map填充数据
     */
    private void getDecodeMap() {
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            huffmanDecodeMap.put(entry.getValue(), entry.getKey());
        }
    }

    /**
     * 将已经编码后的字符串按8位压缩解析为byte数组
     *
     * @param afterCode
     * @return
     */
    private byte[] toZipByteArray(String afterCode) {
        int len = afterCode.length();
        // 返回的字节数组长度为原字符串长度 + 7 整除 8
        byte[] bytes = new byte[(len + 7) / 8];
        int index = 0; // 记录新byte数组下标
        for (int i = 0; i < len; i += 8) {
            String byteStr;
            if (i + 8 < len) {
                byteStr = afterCode.substring(i, i + 8);
            } else { // 要考虑到最后的字符不足8位的情况
                byteStr = afterCode.substring(i);
            }
            bytes[index] = (byte) Integer.parseInt(byteStr, 2);
            index++;
        }

        return bytes;
    }

    /**
     * 将Byte数组根据编码Map集合转换成霍夫曼编码后的字符串
     *
     * @param bytes
     * @return
     */
    private String toStringByCodeMap(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodeMap.get(b));
        }
        return sb.toString();
    }

    /**
     * 重载方法，将霍夫曼树的编码数据存储到Map集合中
     *
     * @param tree
     */
    private void storeRouteToMap(HuffmanTree tree) {
        Node root = tree.root;
        if (root != null) {
            storeRouteToMap(root.left, "0", sb);

            storeRouteToMap(root.right, "1", sb);
        }
    }

    /**
     * 存储霍夫曼编码到Map集合
     *
     * @param node 当前节点
     * @param code 节点路径值，左走为0，右走为1
     * @param sb   最终返回的字符串值
     * @return
     */
    private void storeRouteToMap(Node node, String code, StringBuilder sb) {
        StringBuilder builder = new StringBuilder(sb);
        builder.append(code);
        if (node != null) {
            if (node.data == null) { // 非叶子节点
                // 向左递归
                storeRouteToMap(node.left, "0", builder);
                // 向右递归
                storeRouteToMap(node.right, "1", builder);
            } else { // 叶子节点
                huffmanCodeMap.put(node.data, builder.toString());
            }
        }
    }

    public Map<Byte, String> getHuffmanCodeMap() {
        return huffmanCodeMap;
    }

    public byte[] getAfterCodeBytes() {
        return afterCodeBytes;
    }
}

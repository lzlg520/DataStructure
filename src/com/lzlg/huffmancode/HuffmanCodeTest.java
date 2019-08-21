package com.lzlg.huffmancode;

import java.util.Arrays;

/**
 * 霍夫曼编码：
 * 将传输中的字符串，按照字符
 * 统计字符的个数，根据字符出现的次数构建成霍夫曼树
 * 次数作为权值，其中叶子节点有data（值），而非叶子节点无
 * data。并将从根节点到达叶子节点的路径（左走为0，右走为1）
 * 字符串作为编码，并将得到的所有字符串按照8位一轮，转换成新的byte数组
 */
public class HuffmanCodeTest {
    public static void main(String[] args) {
//        testZipString();
//        testZipFile();
    }

    /**
     * 测试压缩文件
     */
    private static void testZipFile() {
//        String sourceFile = "C:\\Users\\lzlg5\\Pictures\\src.bmp";
//        String targetFile = "C:\\Users\\lzlg5\\Pictures\\m.zip";
//        HuffmanFileZipUtil.zipFile(sourceFile, targetFile);
//        System.out.println("压缩成功！！");

        String sourceFile = "C:\\Users\\lzlg5\\Pictures\\m.zip";
        String targetFile = "C:\\Users\\lzlg5\\Pictures\\55.bmp";
        HuffmanFileZipUtil.unzipFile(sourceFile, targetFile);
        System.out.println("解压缩成功！！");
    }

    /**
     * 测试压缩字符串
     */
    private static void testZipString() {
        String content = "i like like like java do you like a java";
        HuffmanCode huffmanCode = new HuffmanCode(content);
        byte[] afterCodeBytes = huffmanCode.getAfterCodeBytes();
        System.out.println("afterCodeBytes = " + Arrays.toString(afterCodeBytes));

        byte[] decodeBytes = huffmanCode.decode();
        System.out.println("decodeBytes = " + Arrays.toString(decodeBytes));
        String decodeString = new String(decodeBytes);
        System.out.println(decodeString);
    }
}

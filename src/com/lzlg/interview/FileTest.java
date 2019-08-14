package com.lzlg.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileTest {
    public static void main(String[] args) throws Exception {
//        File file = new File("D:\\tt", "User.java");
//        fileInfo(file);

//        decryptFile();


    }

    /**
     * 解密文件
     *
     * @throws Exception
     */
    private static void decryptFile() throws Exception {
        File file = new File("D:\\tt", "data.txt");
        byte[] bytes = new byte[(int) file.length()];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 12);
        }
        randomAccessFile.setLength(0);
        randomAccessFile.write(bytes);
        System.out.println(randomAccessFile.readLine());
    }

    /**
     * 给文件加密
     *
     * @throws Exception
     */
    private static void encryptFile() throws Exception {
        File file = new File("D:\\tt", "data.txt");
        byte[] bytes = new byte[(int) file.length()];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] + 12);
        }
        randomAccessFile.setLength(0);
        randomAccessFile.write(bytes);
        randomAccessFile.seek(3);
        System.out.println((char) randomAccessFile.read());
    }

    private static void fileInfo(File file) {
        System.out.println("文件名：" + file.getName());
        System.out.println("路径：" + file.getPath());
        System.out.println("父路径：" + file.getParent());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        if (file.exists()) {
            System.out.println("文件存在");
            System.out.println("是目录？" + file.isDirectory());
            System.out.println("可读？" + file.canRead());
            System.out.println("可写？" + file.canWrite());
            System.out.println("文件长度为：" + file.length());
            System.out.println("文件最后被修改的日期：" + file.lastModified());
        }
        if (file.delete()) {
            System.out.println(file.exists() ? "删除失败" : "删除成功");
        }
    }
}

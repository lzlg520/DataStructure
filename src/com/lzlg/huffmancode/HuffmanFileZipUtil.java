package com.lzlg.huffmancode;

import java.io.*;
import java.util.Map;

/**
 * 使用霍夫曼编码压缩和解压文件
 */
public class HuffmanFileZipUtil {
    private HuffmanFileZipUtil() {
    }

    /**
     * 压缩文件
     *
     * @param sourceFile 要压缩的文件路径
     * @param targetFile 压缩后的文件存放路径
     */
    public static void zipFile(String sourceFile, String targetFile) {
        try (InputStream is = new FileInputStream(sourceFile);
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(targetFile))) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            // 对数据进行压缩
            HuffmanCode huffmanCode = new HuffmanCode(bytes);
            byte[] codeBytes = huffmanCode.getAfterCodeBytes();
            Map<Byte, String> codeMap = huffmanCode.getHuffmanCodeMap();

            oos.writeObject(codeBytes);
            oos.writeObject(codeMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压缩文件
     *
     * @param zipFile
     * @param targetFile
     */
    public static void unzipFile(String zipFile, String targetFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(zipFile));
             OutputStream os = new FileOutputStream(targetFile)) {
            byte[] bytes = (byte[]) ois.readObject();
            Map<Byte, String> codeMap = (Map<Byte, String>) ois.readObject();
            // 对数据进行压缩
            HuffmanCode huffmanCode = new HuffmanCode(bytes, codeMap);
            byte[] decodeBytes = huffmanCode.decode();
            os.write(decodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

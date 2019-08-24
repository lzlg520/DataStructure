package com.lzlg.algorithm.kmp;

/**
 * KMP算法，字符串匹配算法
 */
public class KMPAlgorithmTest {
    public static void main(String[] args) {
        String mainStr = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String sonStr = "尚硅谷你尚硅你";
//        int index = ForceMatch.match(mainStr, sonStr);
//        System.out.println("暴力匹配：index=" + index);

        int index = KMPMatch.match(mainStr, sonStr);
        System.out.println("KMP匹配：index=" + index);
    }
}

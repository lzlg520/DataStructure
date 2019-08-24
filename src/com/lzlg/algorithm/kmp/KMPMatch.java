package com.lzlg.algorithm.kmp;

import java.util.Arrays;

/**
 * 字符串匹配：KMP算法
 */
public class KMPMatch {
    /**
     * KMP匹配：
     * 从暴力匹配得知，每次移动的位置只有一位
     * 而KMP算法根据一个部分匹配表，来进行快速的移动。
     * <p>
     * 1.部分匹配表
     * 比如子串：ABCDABD
     * 单个字符：A 前缀和后缀字符都为0，匹配的字符长度为0
     * 两个字符：AB 前缀[A]，后缀[B]，匹配的字符长度为0
     * 字符：ABC 前缀[A, AB]，后缀[BC, B]，匹配的字符长度为0
     * 字符：ABCD 前缀[A, AB, ABC]，后缀[BCD, CD, D]，匹配的字符长度为0
     * 字符：ABCDA 前缀[A, AB, ABC, ABCD]，后缀[BCDA, CDA, DA, A]，匹配的字符只有A且长度为1
     * 字符：ABCDAB 前缀[A, AB, ABC, ABCD, ABCDA]，后缀[BCDAB, CDAB, DAB, AB, B]，匹配的字符只有AB匹配的字符长度为2
     * 字符：ABCDABD 前缀[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀[BCDABD, CDABD, DABD, ABD, BD, D]，匹配的字符长度为0
     * <p>
     * 2.移动的规则
     * 主串：BBC ABCDAB ABCDABCDABDE
     * 子串：ABCDABD
     * 当前主串下标为m，子串下标为s
     * <p>
     * 当匹配到这里时：
     * 主串：BBC ABCDAB ABCDABCDABDE
     * 子串：    ABCDABD
     * 发现最后一个字符D和空格不匹配，
     * 如果是暴力匹配则s重置为0，m向前移动一位，重新比较 B和A
     * <p>
     * 但是我们知道字符A已经和主串中后面的的BCD字符比较过，不匹配了。
     * 根据部分匹配表查询得到 ABCDAB匹配长度为2，这时s移动的位数为 ABCDAB的长度 - 匹配的长度2
     * <p>
     * 因此KMP算法是通过部分匹配表来计算移动位数，从而减少重复匹配的次数的算法
     *
     * @param mainStr 被匹配的字符串
     * @param sonStr  要匹配的字符串
     * @return 返回要匹配的字符串sonStr在被匹配字符串mainStr中的第一个匹配到的下标
     * 如果匹配不到，返回 -1
     */
    public static int match(String mainStr, String sonStr) {
        int[] table = matchTable(sonStr);
        char[] mainChars = mainStr.toCharArray();
        char[] sonChars = sonStr.toCharArray();

        int mainLen = mainChars.length;
        int sonLen = sonChars.length;

        for (int i = 0, j = 0; i < mainLen; i++) {
            while (j > 0 && mainChars[i] != sonChars[j]) {
                j = table[j - 1];
            }
            if (mainChars[i] == sonChars[j]) {
                j++;
            }
            if (j == sonLen) {
                return i + 1 - j;
            }
        }
        return -1;
    }

    /**
     * 获取字符串的部分匹配表
     *
     * @param str
     * @return 返回数组，数组的下标为字符串中对应的位置下标
     * 数组的值，代表前面的字符匹配的长度
     */
    private static int[] matchTable(String str) {
        int strLen = str.length();
        int[] result = new int[strLen];
        char[] chars = str.toCharArray();

        result[0] = 0; // 一个字符的匹配长度为0
        for (int i = 1, j = 0; i < strLen; i++) {
            // 如果没有匹配到字符，则让j回到前一个字符
            while (j > 0 && chars[i] != chars[j]) {
                j = result[j - 1];
            }

            if (chars[i] == chars[j]) {// 当匹配到字符时，j++
                j++;
            }
            result[i] = j;
        }

        return result;
    }
}

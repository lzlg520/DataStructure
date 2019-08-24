package com.lzlg.algorithm.kmp;

/**
 * 字符串匹配：暴力匹配
 */
public class ForceMatch {
    /**
     * 暴力匹配
     *
     * @param mainStr 被匹配的字符串
     * @param sonStr  要匹配的字符串
     * @return 返回要匹配的字符串sonStr在被匹配字符串mainStr中的第一个匹配到的下标
     * 如果匹配不到，返回 -1
     */
    public static int match(String mainStr, String sonStr) {
        // 字符串对应的字符数组
        char[] mainChars = mainStr.toCharArray();
        char[] sonChars = sonStr.toCharArray();
        // 字符数组的长度
        int mainLen = mainChars.length;
        int sonLen = sonChars.length;

        int m = 0; // 记录mainChars对应的下标
        int s = 0; // 记录sonChars对应的下标
        while (m < mainLen && s < sonLen) {
            if (mainChars[m] == sonChars[s]) {// 如果匹配到，则下标相应的++
                m++;
                s++;
            } else {
                // 而母串则从没被匹配到的字符的下个位置进行
                // m-s返回没有匹配到的字符位置，+1则是从该字符的下个位置进行
                m = m - s + 1;
                // 如果没有匹配到，则从头遍历子串的字符数组，因此s = 0
                s = 0;
            }
        }

        if (s == sonLen) { // 如果全部匹配到了子串，则s==sonLen
            // 此时m的值等于 子串的长度 + 跳过的未被匹配到的字符长度
            return m - s;
        } else {
            return -1;
        }
    }
}

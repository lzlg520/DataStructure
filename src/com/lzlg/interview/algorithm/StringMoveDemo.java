package com.lzlg.interview.algorithm;

/**
 * 有以下字符串：ab**cd**e*12
 * 处理后为 *****abcde12
 * 且返回值为 * 的个数5
 * 要求*的顺序不能改变，且要使用最少的辅助空间和时间
 */
public class StringMoveDemo {
    public static void main(String[] args) {
        String content = "ab**cd**e*12";
        char[] chars = content.toCharArray();

        int i, j = chars.length - 1;
        for (i = j; j >= 0; j--) {
            System.out.println("char[i]=" + chars[i]);
            System.out.println("char[j]=" + chars[j]);
            if (chars[i] != '*') {
                i--;
            } else if (chars[j] != '*') {
                chars[i] = chars[j];
                chars[j] = '*';
                i--;
            }
        }

        String newStr = new String(chars);
        System.out.println(newStr);
        System.out.println(i + 1);
    }
}

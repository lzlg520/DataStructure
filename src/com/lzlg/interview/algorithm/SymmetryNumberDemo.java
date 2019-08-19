package com.lzlg.interview.algorithm;

import java.util.Scanner;

/**
 * 判断回文数字
 * 12321
 * 123321
 */
public class SymmetryNumberDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个回文整数：");
        int no = scanner.nextInt();
        System.out.println(no + "是回文数字吗？" + isRightNo(no));
    }

    private static boolean isSymmetryNumber(int number) {
        String[] array = (number + "").split("");
        for (int i = 0; i < array.length / 2; i++) {
            if (!array[i].equals(array[array.length - i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRightNo(int no) {
        String noStr = no + "";
        String reverseStr = new StringBuilder(noStr).reverse().toString();
        return noStr.equals(reverseStr);
    }
}

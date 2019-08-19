package com.lzlg.interview.algorithm;

import java.util.Scanner;

/**
 * 编写一个截取字符串的函数：
 * 1.输入一个字符串和字节数，输出为按字节截取的字符串。
 * 2.保证汉字不被截取半个。
 * 3.举例："我 ABC" 4 --> "我 AB"
 * "我 ABC 汉 DEF" 6 --> "我 ABC"
 */
public class InterceptStringDemo {
    static String input;
    static int n;

    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        input = scanner.next();

        System.out.println("请输入字节数：");
        n = scanner.nextInt();

        intercept(setValue());

    }

    private static String[] setValue() {
        if (input == null || input.equals("")) {
            throw new RuntimeException("没有输入内容");
        }
        return input.split("");
    }

    private static void intercept(String[] array) {
        System.out.println("以每" + n + "字节划分的字符串如下所示：");

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("[\u4e00-\u9fa5]")) {
                count += 2;
            } else {
                count += 1;
            }

            if (count < n) {
                System.out.print(array[i]);
            } else if (count == n) {
                System.out.print(array[i]);
                count = 0;
                System.out.println();
            } else {
                count = 0;
                System.out.println();
            }
        }
    }

}

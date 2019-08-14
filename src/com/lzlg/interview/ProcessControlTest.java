package com.lzlg.interview;

import java.util.Scanner;

public class ProcessControlTest {
    public static void main(String[] args) {
//        boolean a = false;
//        boolean b = false;
//        if (b = true) {
//            System.out.println("What fuck a day!");
//        }

        // 使用位运算 boolean 可避免短路行为
        /*
        boolean a = true;
        String s = null;

        System.out.println(a || s.equals(""));
        if (a || s.equals("")) {
            System.out.println("How are you!");
        }

        System.out.println(a | s.equals(""));
        if (a | s.equals("")) {
            System.out.println("How are you!");
        }
        */

//        letterSwitch();

//        primeTest();

//        narcissisticNumber();

//        printMultiTable();

        printFactorial();
    }

    /**
     * 闰年：
     * 能被400整除的 或者 能被4整除的但不能被100整除的数
     */
    private static void isLeapYear() {
        int year = (int) (Math.random() * 10000);
        boolean a = year % 400 == 0;
        boolean b = (year % 4 == 0) && (year % 100 != 0);
        boolean isLeap = a || b;
        System.out.println(isLeap ? "是闰年" : "不是闰年");
    }

//    final static short a = 3;
//    public static int b = 1;
//
//    private static void testSwitch() {
//        for (int i = 0; i < 5; i++) {
//            switch (i) {
//                case b: // 此处编译不过，因为b不是常量
//                    System.out.println("4 ");
//                case a - 1:
//                    System.out.println("5 ");
//                case a:
//                    System.out.println("6 ");
//            }
//        }
//    }

    /**
     * 用户输入一个字母
     * 判断是元音还是辅音
     */
    private static void letterSwitch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字母：");
        String input = scanner.next();
        input = input.toLowerCase();
        switch (input) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                System.out.println("您输入的是元音字母");
                break;
            default:
                System.out.println("您输入的是辅音字母");
                break;
        }
    }

    /**
     * 输出 1~100之间的素数
     */
    private static void primeTest() {
        int count = 0;
        for (int i = 3; i <= 100; i++) {
            boolean isPrime = true;
            int n = (int) Math.sqrt(i); // 从 2 到 n 的平方根
            for (int j = 2; j <= n; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
                System.out.print(i + " ");
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * 循环嵌套
     */
    private static void loopNesting() {
        int n = 1;
        do while (n > 1)
            System.out.println("The result is " + n);
        while (n > 1);

        // 上面的等价于

        do {
            while (n > 1) {
                System.out.println("The result is " + n);
            }
        } while (n > 1);
    }

    /**
     * 水仙花数
     * 一个3位数等于每个位数上的3次幂之和
     */
    private static void narcissisticNumber() {
        for (int i = 100; i <= 999; i++) {
            int bai = i / 100;
            int shi = i / 10 % 10;
            int ge = i % 10;
//            System.out.println("百位：" + bai + "；十位：" + shi + "；个位：" + ge);
            if ((bai * bai * bai + shi * shi * shi + ge * ge * ge) == i) {
                System.out.println("水仙花数：" + i);
            }
        }
    }

    /**
     * 打印9x9乘法表
     */
    private static void printMultiTable() {
        flag:
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j > i) {
                    System.out.println();
                    continue flag;
                }
                System.out.print(i * j + " ");
            }
        }
    }

    /**
     * 打印1~10的阶乘
     * 要求使用break
     */
    private static void printFactorial() {
        for (int i = 1; i <= 10; i++) {
            int result = 1;
            int j = 0;
            while (true) {
                j++;
                if (j > i) {
                    break;
                }
                result *= j;
            }
            System.out.println(i + "的阶乘为：" + result);
        }
    }
}

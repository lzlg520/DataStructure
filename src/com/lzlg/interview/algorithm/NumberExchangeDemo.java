package com.lzlg.interview.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从键盘上输入10个整数，并将其放入一个一维数组中，
 * 然后将其前5个元素和后5个元素对换，
 * 分别输出数组原来的元素值和对换后的元素值
 */
public class NumberExchangeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            array[i] = scanner.nextInt();
        }
        System.out.println("原来的数组：" + Arrays.toString(array));

        doExchange(array);

        System.out.println("兑换后的数组：" + Arrays.toString(array));
    }

    private static void doExchange(int[] array) {
        int len = array.length;
        int count = len / 2;
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
    }
}

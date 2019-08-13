package com.lzlg.interview;

import java.util.Random;

public class ArrayTest {
    /**
     * 数组元素初始化值
     * 1.Byte -> 0
     * 2.Short -> 0
     * 3.Int -> 0
     * 4.Long -> 0
     * 5.Char -> \u0000
     * 6.Float -> 0.0f
     * 7.Double -> 0.0d
     * 8.Boolean -> false
     * 9.Object Reference -> null
     */
    public static void main(String[] args) {
        // 二维数组，声明方式
//        int[] array[] = new int[10][10];
        /*
        String[] myChars = {"a", "b", "c", "d"};
        // 无参数运行程序 args 初始化为 无长度的数组 即： String[] args = new String[0]
        if (args.length == 0) {
            System.out.println("No result.");
        } else {
            System.out.println(myChars[args.length] + " result");
        }
        */
        /*
        int[] array = new int[10];

        System.out.println("未初始化赋值的数组：");
        print(array);
        initArray(array);
        System.out.println("已经初始化赋值的数组：");
        print(array);
        System.out.println("查询到数组中的最大值为：" + findMax(array));
        */

//        twoDimensionalArray();

//        testArrayLength();

//        int[][] array = new int[5][8];
//        System.out.println(array[2].length);

        testDesignArray();
    }

    private static void testDesignArray() {
        // 1.初始化两个数组
        int[] a = {12, 65, 21, 23, 98};
        int[] b = {15, 61, 66, 33, 90};
        System.out.println("数组 a 的长度为：" + a.length + "；数组 a 中拥有的元素有：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n数组 b 的长度为：" + b.length + "；数组 b 中拥有的元素有：");
        for (int i : b) {
            System.out.print(i + " ");
        }

        int[] c = new int[5];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] * b[i];
        }
        System.out.println("\n数组 c 的长度为：" + c.length + "；数组 c 中拥有的元素有：");
        for (int i : c) {
            System.out.print(i + " ");
        }

        int[] d = new int[5];
        for (int i = 0; i < d.length; i++) {
            d[i] = a[i] * c[i] - b[i];
        }

        System.out.println("\n数组 d 的长度为：" + d.length + "；数组 d 中拥有的元素有：");
        for (int i : d) {
            System.out.print(i + " ");
        }
    }


    private static void testArrayLength() {
        int[][][] array = new int[4][][];
        int sum = 0;
        int count = 0;
        array[0] = new int[4][];
        array[1] = new int[2][];
        array[2] = new int[5][];
        array[3] = new int[3][];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new int[i + j + 1];
                count++;
            }
            sum += array[i].length;
        }
        System.out.println("count is equals sum ? " + (count == sum ? "yes" : "no"));
    }

    private static void twoDimensionalArray() {
        int[][] score = {
                {60, 70, 85, 45},
                {89, 78, 86, 66},
                {56, 84, 76, 91}
        };
        for (int i = 0; i < score.length; i++) {
            int sum = 0;
            System.out.print("第" + (i + 1) + "人的成绩为：");
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + " ");
                sum += score[i][j];
            }
            System.out.println("总成绩为：" + sum);
        }
    }

    /**
     * 打印数组中的元素
     *
     * @param array
     */
    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("index is %d, value is %d.\n", i, array[i]);
        }
    }

    /**
     * 给数组赋值
     *
     * @param array
     */
    private static void initArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    /**
     * 查找数组中的最大值
     *
     * @param array
     * @return
     */
    private static int findMax(int[] array) {
        int len = array.length;
        if (len == 0) {
            throw new RuntimeException("空数组");
        }
        int max = array[0];
        for (int i = 1; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}

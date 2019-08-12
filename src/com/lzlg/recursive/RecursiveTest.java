package com.lzlg.recursive;

public class RecursiveTest {
    public static void main(String[] args) {

        print(5);

        System.out.printf("%d's factorial is %d.", 10, factorial(10));

    }

    /**
     * 依次打印从 1 ~ n 之间的数字
     *
     * @param n
     */
    private static void print(int n) {
        if (n > 1) {
            print(n - 1);
        }
        System.out.println("n = " + n);
    }

    /**
     * 阶乘问题 计算 n 的阶乘
     *
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return factorial(n - 1) * n;
    }
}

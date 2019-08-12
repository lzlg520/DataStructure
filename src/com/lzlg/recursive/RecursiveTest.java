package com.lzlg.recursive;

public class RecursiveTest {
    public static void main(String[] args) {

        print(5);

        System.out.printf("%d's factorial is %d.\n", 10, factorial(10));

        System.out.printf("The %d's fibonacci number is %d.\n", 8, fibonacci(8));

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

    /**
     * 打印出第 n 个斐波那契数列的值
     * 0, 1, 1, 2, 3, 5, 8, 13
     *
     * @param
     * @return
     */
    private static int fibonacci(int n) {
        if ((n == 1) || (n == 2)) {
            return n - 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

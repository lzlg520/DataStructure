package com.lzlg.interview.algorithm;


/**
 * 哥德巴赫猜想：
 * 大于2的偶数都能表示为两个素数之和
 * 请编写一个java程序，验证 1~100 内哥德巴赫猜想的正确
 */
public class GoldbachDemo {
    public static void main(String[] args) {
        if (verify(1, 100)) {
            System.out.println("在 1~100 范围内，哥德巴赫猜想是正确的。");
        } else {
            System.out.println("哥德巴赫猜想是错误的。");
        }
    }

    /**
     * 验证从low到high之间的数字是否满足哥德巴赫猜想
     *
     * @param low
     * @param high
     * @return
     */
    private static boolean verify(int low, int high) {
        boolean flag = true;
        int j = 0;
        for (int i = low; i <= high; i++) {
            if (i > 2 && i % 2 == 0) {
                if (isGoldbach(i)) {
                    j++;
                    if (j == 5) {
                        System.out.println();
                        j = 0;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 验证a是否符合哥德巴赫猜想
     * a = 1 + (a - 1)
     * a = 2 + (a - 2)
     * ....
     * a = a / 2 + a / 2
     *
     * @param a
     * @return
     */
    private static boolean isGoldbach(int a) {
        boolean flag = false;
        for (int i = 1; i <= a / 2; i++) {
            if (isPrime(i) && isPrime(a - i)) {
                flag = true;
                System.out.print(a + "=" + i + "+" + (a - i) + " ");
                break;
            }
        }
        return flag;
    }

    /**
     * 判断一个数是否是素数
     *
     * @param i
     * @return
     */
    private static boolean isPrime(int i) {
        boolean flag = true;
        if (i == 1) {
            flag = false;
        }
        for (int n = 2; n <= i - 1; n++) {
            if (i % n == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

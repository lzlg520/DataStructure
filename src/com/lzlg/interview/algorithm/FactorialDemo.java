package com.lzlg.interview.algorithm;

/**
 * 阶乘问题：
 * 1.一个正整数N的阶乘莫问有多少个零？
 * 2.求N的阶乘二进制表示中最低位1的位置
 */
public class FactorialDemo {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(getZeroCount(15));

        System.out.println(getLastOne(6));
    }

    /**
     * 末尾有多少个0
     * 看 1~n 之间有多少被5整除的数
     *
     * @param n
     * @return
     */
    private static int getZeroCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 一个正整数二进制最低位1的位置：如果是奇数肯定是1
     * 如果是偶数，则需要该正整数一直除以2，直到除不尽2为止，该次数+1就是最低位1的位置
     * 即求该偶数含有质因数为2的个数
     *
     * @param n
     * @return
     */
    private static int getLastOne(int n) {
        int count = 1;
        while (n != 0) {
            n >>= 1;
            count += n;
        }
        return count;
    }
}

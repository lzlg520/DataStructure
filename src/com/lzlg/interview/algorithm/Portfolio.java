package com.lzlg.interview.algorithm;

/**
 * 有四种面值的邮票，面值分别为1分，4分，12分，21分
 * 现从多张中任取5张进行组合，求这些邮票的最大连续组合值
 */
public class Portfolio {
    static int num = 5, M = 5;
    static int k;
    static boolean find;
    static int[] logo = new int[num];
    static int[] stamp = {0, 1, 4, 12, 21};

    public static boolean comable(int n, int value) {
        if (n >= 0 && value == 0) {
            find = true;
            int sum = 0;
            for (int i = 0; i < num && logo[i] != 0; i++) {
                sum += stamp[logo[i]];
                System.out.print(stamp[logo[i]] + " , ");
            }
            System.out.println("总数为：" + sum);
        } else {
            for (int i = 1; i < M && !find && n > 0; i++) {
                if (value - stamp[i] >= 0) {
                    logo[k++] = i;
                    comable(n - 1, value - stamp[i]);
                    logo[--k] = 0;
                }
            }
        }
        return find;
    }

    public static void main(String[] args) {
        for (int i = 1; comable(num, i); i++, find = false) ;
    }
}

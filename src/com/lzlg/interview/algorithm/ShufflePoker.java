package com.lzlg.interview.algorithm;

/**
 * 洗扑克牌的原理和乱数排列是相同的，都是将一组数字打乱从小排列
 * 现要求按照花色来排列扑克牌
 */
public class ShufflePoker {
    public static void main(String[] args) {
        final int N = 52;
        int[] poker = new int[N + 1];
        // 初始化扑克牌
        for (int i = 1; i <= N; i++) {
            poker[i] = i;
        }
        // 洗牌，洗牌是通过获取随机数组下标来进行的，这样不用一一比对
        for (int i = 1; i <= N; i++) {
            int j = (int) (Math.random() * N);
            if (j == 0) {
                j = 1;
            }
            int mid = poker[i];
            poker[i] = poker[j];
            poker[j] = mid;
        }
        // 牌分类
        for (int i = 1; i <= N; i++) {
            switch ((poker[i] - 1) / 13) {
                case 0:
                    System.out.print("黑桃");
                    break;
                case 1:
                    System.out.print("红心");
                    break;
                case 2:
                    System.out.print("红砖");
                    break;
                case 3:
                    System.out.print("黑梅");
                    break;
            }
            // 特殊牌名
            int number = poker[i] % 13;
            switch (number) {
                case 0:
                    System.out.print("K ");
                    break;
                case 1:
                    System.out.print("A ");
                    break;
                case 12:
                    System.out.print("Q ");
                    break;
                case 11:
                    System.out.print("J ");
                    break;
                default:
                    System.out.print(number + " ");
                    break;
            }
            // 换行
            if (i % 13 == 0) {
                System.out.println();
            }
        }
    }
}

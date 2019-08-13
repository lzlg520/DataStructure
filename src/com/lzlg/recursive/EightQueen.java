package com.lzlg.recursive;

/**
 * 递归--8皇后问题
 */
public class EightQueen {
    /**
     * 数组长度
     */
    private int size = 8;
    /**
     * 一维数组记录八个位置
     * 数组的下标+1记录 该位置所在的行数
     * 数组的下标对应的值+1记录 该位置所在的列数
     */
    private int[] array = new int[size];

    private static int count = 0;

    private static int judgeCount = 0;

    public static void main(String[] args) {

        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共判断冲突的次数为：%d次\n", judgeCount);

    }

    /**
     * 根据判断的规则，回溯所有的情况
     *
     * @param n
     */
    private void check(int n) {
        if (n == size) {
            print();
            return;
        }
        for (int i = 0; i < size; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 判断规则
     *
     * @param n 第几个球：0 到 7
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        // 判断是否在同一斜线上,在同一列上
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印单个结果的值
     */
    private void print() {
        count++;
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}

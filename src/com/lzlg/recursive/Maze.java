package com.lzlg.recursive;

/**
 * 递归--迷宫问题
 */
public class Maze {

    public static void main(String[] args) {
        int[][] array = init();
        System.out.println("原始迷宫=====>>>>>");
        print(array);

        isCanPass(array, 1, 1);

        System.out.println("迷宫走过之后=====>>>>>");
        print(array);
    }

    /**
     * 起点 array[1][1]
     * 终点 array[6][5]
     * 1：代表墙
     * 2：已经走过
     * 3：不能走
     * 走迷宫策略 下->右->上->左
     *
     * @param array
     * @param x
     * @param y
     * @return
     */
    private static boolean isCanPass(int[][] array, int x, int y) {
        if (array[6][5] == 2) {
            return true;
        }
        if (array[x][y] == 0) {
            array[x][y] = 2;
            if (walkStrategy(array, x, y)) {
                return true;
            } else { // 走不通，变为3
                array[x][y] = 3;
                return false;
            }
//            if (isCanPass(array, x + 1, y)) { // 向下走
//                return true;
//            } else if (isCanPass(array, x, y + 1)) { // 向右走
//                return true;
//            } else if (isCanPass(array, x - 1, y)) { // 向上走
//                return true;
//            } else if (isCanPass(array, x, y - 1)) { // 向左走
//                return true;
//            } else { // 走不通，变为3
//                array[x][y] = 3;
//                return false;
//            }
        } else {
            return false;
        }
    }


    /**
     * 封装行走策略
     *
     * @return
     */
    private static boolean walkStrategy(int[][] array, int x, int y) {
        if (isCanPass(array, x + 1, y)) { // 向下走
            return true;
        } else if (isCanPass(array, x, y + 1)) { // 向右走
            return true;
        } else if (isCanPass(array, x - 1, y)) { // 向上走
            return true;
        } else if (isCanPass(array, x, y - 1)) { // 向左走
            return true;
        } else {
            return false;
        }
    }

    /**
     * 初始化数据方法
     *
     * @return
     */
    private static int[][] init() {
        // 二维数组， 8行7列
        int row = 8;
        int column = 7;
        int[][] array = new int[row][column];

        // 初始化 第一行和最后一行数据为1
        for (int i = 0; i < row; i++) {
            array[i][0] = 1;
            array[i][column - 1] = 1;
        }

        // 初始化 第一列和最后一列数据为1
        for (int i = 0; i < column; i++) {
            array[0][i] = 1;
            array[row - 1][i] = 1;
        }

        // 其他部分的墙
        array[3][1] = 1;
        array[3][2] = 1;

//        array[1][2] = 1;
//        array[2][2] = 1;

        return array;
    }

    /**
     * 打印二维数组数据
     */
    private static void print(int[][] array) {
        for (int[] item : array) {
            for (int i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

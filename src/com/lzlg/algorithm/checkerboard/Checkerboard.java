package com.lzlg.algorithm.checkerboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 棋盘类
 */
public class Checkerboard {
    private static final int X = 8;// 棋盘的列数
    private static final int Y = 8;// 棋盘的行数
    private static boolean[] visited = new boolean[X * Y]; // 记录棋盘的各个位置是否已经访问过
    private static boolean finished = false; // 记录是否已经完成

    public static void horseTread(Point point) {
        System.out.println("start~~~~~~~~~~~~");
        int[][] checkerboard = new int[X][Y];
        long start = System.currentTimeMillis();
        horseTread(checkerboard, point.y, point.x, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");
        showCheckerboard(checkerboard);
    }

    private static void showCheckerboard(int[][] checkerboard) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                System.out.printf("%5d", checkerboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 马踏棋盘
     *
     * @param checkerboard
     * @param step
     */
    private static void horseTread(int[][] checkerboard, int row, int col, int step) {
        // 记录棋盘的步数
        checkerboard[row][col] = step;
        // 该棋盘的位置已经访问过
        visited[row * X + col] = true;

        List<Point> nextPoints = getNextSteps(new Point(col, row));
        sortNextSteps(nextPoints);

        while (!nextPoints.isEmpty()) {
            Point p = nextPoints.remove(0);
            if (!visited[p.y * X + p.x]) {// 如果没有访问过，则递归调用该方法
                horseTread(checkerboard, p.y, p.x, step + 1);
            }
        }
        // 如果没有走通，则重置棋盘，和已访问数组信息
        if (step < X * Y && !finished) {
            checkerboard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }

    }

    /**
     * 根据当前马的位置，计算出马能走的位置的集合
     *
     * @param point 注意 此时x 的表示列 y表示行
     * @return
     */
    private static List<Point> getNextSteps(Point point) {
        List<Point> list = new ArrayList<>();
        if ((point.x - 2) >= 0 && (point.y - 1) >= 0) {
            list.add(new Point(point.x - 2, point.y - 1));
        }

        if ((point.x - 1) >= 0 && (point.y - 2) >= 0) {
            list.add(new Point(point.x - 1, point.y - 2));
        }

        if ((point.x + 1) < X && (point.y - 2) >= 0) {
            list.add(new Point(point.x + 1, point.y - 2));
        }

        if ((point.x + 2) < X && (point.y - 1) >= 0) {
            list.add(new Point(point.x + 2, point.y - 1));
        }

        if ((point.x - 1) >= 0 && (point.y + 2) < Y) {
            list.add(new Point(point.x - 1, point.y + 2));
        }

        if ((point.x - 2) >= 0 && (point.y + 1) < Y) {
            list.add(new Point(point.x - 2, point.y + 1));
        }

        if ((point.x + 1) < X && (point.y + 2) < Y) {
            list.add(new Point(point.x + 1, point.y + 2));
        }

        if ((point.x + 2) < X && (point.y + 1) < Y) {
            list.add(new Point(point.x + 2, point.y + 1));
        }

        return list;
    }

    /**
     * 将下一次要遍历的棋盘位置排序
     * 规则是：让他们按照下一次的能走的位置的数量 递增排序
     * 这样能使回溯的次数减少
     *
     * @param list
     */
    private static void sortNextSteps(List<Point> list) {
        list.sort((p1, p2) -> {
            int next1 = getNextSteps(p1).size();
            int next2 = getNextSteps(p2).size();
            if (next1 < next2) {
                return -1;
            } else if (next1 == next2) {
                return 0;
            } else {
                return 1;
            }
        });
    }
}

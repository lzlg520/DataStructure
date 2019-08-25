package com.lzlg.algorithm.checkerboard;

import java.awt.*;

/**
 * 马踏棋盘算法：
 * 有个8x8的棋盘，让马走 日 字 走完该棋盘的所有位置
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("开始运行====");
        Point point = new Point(0, 0);
        Checkerboard.horseTread(point);
    }
}

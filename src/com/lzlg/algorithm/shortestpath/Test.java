package com.lzlg.algorithm.shortestpath;

import com.lzlg.algorithm.Graph;

/**
 * 最短路径的两种解法：
 * 1.迪杰斯特拉算法
 * 2.弗洛伊德算法
 */
public class Test {

    private static final int N = 10000;

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };

        Graph graph = new Graph(data, matrix);

        DijkstraAlgorithm.getMinPath(graph, 0);
    }
}

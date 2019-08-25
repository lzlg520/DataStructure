package com.lzlg.algorithm.shortestpath;

import com.lzlg.algorithm.Graph;

/**
 * 弗洛伊德算法：
 * 求解每个顶点到各个顶点的最短路径
 * 1.维护一个保存各个顶点的前驱顶点的二维数组
 * 2.出发顶点i，中间顶点j，结束节点k，
 * 比较i->j->k的路径距离 Lijk 和 i->k的路径距离 lik
 * 如果Lijk的距离小于Lik的距离，则更新邻接矩阵的值matrix[i][k]的值
 * 同时更新前驱二维数组的对应的顶点信息
 */
public class FloydAlgorithm {
    /**
     * 根据弗洛伊德算法计算出各个顶点到所有顶点的信息
     *
     * @param graph
     */
    public static void getMinPath(Graph graph) {
        int vertexCount = graph.getVertexCount();
        int[][] matrix = graph.getMatrix();
        int[][] preVertex = graph.getPreVertex();
        for (int i = 0; i < vertexCount; i++) {
            matrix[i][i] = 0;
        }

        int len;// 记录路径距离

        // i表示中间顶点
        for (int i = 0; i < vertexCount; i++) {
            // j表示出发顶点
            for (int j = 0; j < vertexCount; j++) {
                // k表示结束顶点
                for (int k = 0; k < vertexCount; k++) {
                    len = matrix[j][i] + matrix[i][k]; // 表示j -> i -> k的路径
                    if (len < matrix[j][k]) { // 判断是否小于 j -> k 的路径
                        matrix[j][k] = len; // 将最短路径更新
                        preVertex[j][k] = preVertex[i][k]; // 将j->k的前驱顶点改为i
                    }
                }

            }
        }
        // 显示结果
        graph.floydShow();
    }

}

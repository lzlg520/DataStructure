package com.lzlg.algorithm;

import java.util.Arrays;

/**
 * 图对象
 */
public class Graph {

    private static final int N = 10000;

    // 顶点数量
    private int vertexCount;
    // 顶点数据数组
    private char[] data;
    // 邻接矩阵
    private int[][] matrix;
    // 边的数量
    private int edgeCount;
    // 前驱节点的信息
    // preVertex[i][j]的值 表示顶点i 到达 顶点j的前驱顶点的下标
    private int[][] preVertex;

    /**
     * 构造方法
     *
     * @param data
     * @param matrix
     */
    public Graph(char[] data, int[][] matrix) {
        vertexCount = data.length;
        this.data = data;
        this.matrix = matrix;

        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (matrix[i][j] != N) {
                    edgeCount++;
                }
            }
        }

        // 初始化记录前驱顶点的数组
        // 让i->j的前驱节点变为i
        this.preVertex = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            Arrays.fill(preVertex[i], i);
        }
    }

    /**
     * 展示矩阵信息
     */
    public void show() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 显示弗洛伊德算法的结果
     */
    public void floydShow() {
        // 显示前驱顶点信息
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(data[preVertex[i][j]] + " ");
            }
            System.out.println();
            // 显示邻接矩阵信息
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(data[i] + "->" + data[j] + "的最短路径为：" + matrix[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * 查询字符c在顶点数组中的下标
     *
     * @param c
     * @return 查找不到返回-1
     */
    public int getPos(char c) {
        for (int i = 0; i < vertexCount; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取边的对象数组
     *
     * @return
     */
    public Edge[] getEdges() {
        Edge[] edges = new Edge[edgeCount];
        int index = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (matrix[i][j] != N) {
                    edges[index++] = new Edge(data[i], data[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public char[] getData() {
        return data;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public int[][] getPreVertex() {
        return preVertex;
    }
}

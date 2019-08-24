package com.lzlg.algorithm.kruskal;

import com.lzlg.algorithm.Edge;
import com.lzlg.algorithm.Graph;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法：
 * 算法思想：
 * 1.首先对边按照权值从小到大排序
 * 2.依次选择权值最小的边
 * 3.再选择权值最小的边的时候，要判断是否构成回路
 * 4.如果构成回路，跳过该边，选择下一个边
 * 5.直到所有的顶点都被访问过
 * <p>
 * 概念解释：
 * 回路：有数据为这样的图 [A, B, C, D, E, F, G]
 * 假如 已经选择三天边 F->E, C->D, D->E
 * 这时要加入第四条边 C->E
 * 由于C的终点为F，E的终点也为F，所以C->E这条边会造成回路。
 * <p>
 * 终点：对已经连接过的顶点，他们的终点是能到达的已连接过的最大顶点（包括自己）
 * 上个例子：
 * C的终点为 F（能到达的已链接过的最大顶点，虽然最大顶点为G，但G没链接过）
 * D的终点为 F
 * E的终点为 F
 * F的终点为 F
 */
public class KruskalAlgorithm {

    private static final int N = 10000;

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {N, 12, N, N, N, 16, 14},
                {12, N, 10, N, N, 7, N},
                {N, 10, N, 3, 5, 6, N},
                {N, N, 3, N, 4, N, N},
                {N, N, 5, 4, N, 2, 8},
                {16, 7, 6, N, 2, N, 9},
                {14, N, N, N, 8, 9, N}
        };

        Graph graph = new Graph(data, matrix);
        Edge[] minTreeEdges = getMinTreeEdges(graph);

        System.out.println(Arrays.toString(minTreeEdges));
    }

    /**
     * 获取最小生成树的边的数组
     *
     * @param graph
     * @return
     */
    private static Edge[] getMinTreeEdges(Graph graph) {
        int vertexCount = graph.getVertexCount();
        // 返回的结果，选择最小生成树的边的数组
        Edge[] result = new Edge[vertexCount - 1];

        // 用于记录该数组下标对应的顶点的终点的下标
        int[] ends = new int[vertexCount];

        // 获取边的对象数组，并排序
        Edge[] edges = graph.getEdges();
        sortEdges(edges);

        for (int i = 0, index = 0; i < edges.length; i++) {
            int p1 = graph.getPos(edges[i].getStart()); // 获取这条边的一个顶点的下标
            int p2 = graph.getPos(edges[i].getEnd()); // 获取这条边的另一个顶点的下标

            // 获取这些顶点的终点下标
            int e1 = getEndPos(ends, p1);
            int e2 = getEndPos(ends, p2);
            // 判断终点是否相同，如果相同（会构成回路），不加入结果数组中，否则加入
            if (e1 != e2) {
                ends[e1] = e2;// 注意此时，更新对应顶点下标的终点的信息
                result[index++] = edges[i];
            }
        }

        return result;
    }

    /**
     * 根据权重大小排序边
     *
     * @param edges
     */
    private static void sortEdges(Edge[] edges) {
        Arrays.sort(edges);
    }

    /**
     * 获取下标为vertexIndex的顶点的终点的下标
     * 用于获取一个顶点的终点
     *
     * @param ends        数组记录的下标对应的字符顶点的终点的顶点下标
     * @param vertexIndex 下标为vertexIndex的顶点
     * @return
     */
    private static int getEndPos(int[] ends, int vertexIndex) {
        while (ends[vertexIndex] != 0) {
            vertexIndex = ends[vertexIndex];
        }
        return vertexIndex;
    }
}

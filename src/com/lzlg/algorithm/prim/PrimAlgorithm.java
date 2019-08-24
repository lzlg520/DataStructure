package com.lzlg.algorithm.prim;

import com.lzlg.algorithm.Graph;

/**
 * 普利姆算法：
 * 结合修路问题讲诉普利姆算法的思想：
 * 1.从A顶点开始，出发的几条边中选出权值最小的边所到达的顶点
 * A->B[5],A->C[7],A->G[2]
 * 这里是G，然后把A和G加入集合中
 * <p>
 * 2.同时从A，G顶点出发，选出没有被访问过顶点的，能到达的边的信息
 * A->C[7],A->B[5],G->B[3],G->E[4],G->F[6]
 * 从这些边中选出权值最小的边，和该边所到达的顶点
 * 这里是B，然后把B加入集合中
 * <p>
 * 3.再次从A，G，B顶点出发，照1，2的方式进行
 * 直到集合包含所有顶点，边能到达所有顶点，
 * 这时边的权值之和为最小，即生成了最小生成树
 */
public class PrimAlgorithm {
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

        Graph graph = createGraph(data, matrix);
        graph.show();

        primToMinTree(graph, 'A');
    }

    /**
     * 创建图对象
     *
     * @param data
     * @param matrix
     * @return
     */
    private static Graph createGraph(char[] data, int[][] matrix) {
        if (data.length == matrix.length) {
            return new Graph(data, matrix);
        } else {
            throw new RuntimeException("Wrong data");
        }
    }

    private static void primToMinTree(Graph graph, char c) {
        char[] data = graph.getData();
        int pos = -1;
        for (int i = 0; i < data.length; i++) {
            if (c == data[i]) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            throw new RuntimeException("Wrong character!");
        }

        int[][] matrix = graph.getMatrix();
        int vertexCount = graph.getVertexCount();
        // 创建一个数组，用来标记顶点是否已经访问过
        boolean[] visited = new boolean[vertexCount];
        // 标记pos位置的数据已经被访问过
        visited[pos] = true;

        int minWeight = N; // 用来记录最小权值
        // 从A开始，访问A能到达的所有顶点
        int startIndex = -1; // 记录已访问节点的位置下标
        int endIndex = -1;  // 记录未访问节点的位置下标

        for (int i = 1; i < vertexCount; i++) { // 只记录6条边的信息

            // j循环的是已访问过的顶点位置下标
            for (int j = 0; j < vertexCount; j++) {
                // k循环的是未访问过的顶点位置下标
                for (int k = 0; k < vertexCount; k++) {
                    if (visited[j] && !visited[k] && matrix[j][k] < minWeight) {
                        minWeight = matrix[j][k];
                        startIndex = j;
                        endIndex = k;
                    }
                }
            }

            System.out.println("边<" + data[startIndex] + "->" + data[endIndex] + "> : "
                    + matrix[startIndex][endIndex]);
            // 退出循环后，次数从A出发访问的顶点标记未以访问
            visited[endIndex] = true;
            // 必须重置minWeight，否则会一直保持最小权值的边
            minWeight = N;
        }

    }
}

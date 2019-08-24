package com.lzlg.algorithm.shortestpath;

import com.lzlg.algorithm.Graph;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法：
 * 求单个顶点，到达其余顶点的最短路径问题
 */
public class DijkstraAlgorithm {

    public static void getMinPath(Graph graph, int index) {
        // 获取顶点个数
        int vertexCount = graph.getVertexCount();
        // 获取邻接矩阵信息
        int[][] matrix = graph.getMatrix();
        // 创建顶点访问对象信息
        VisitedVertex visitedVertex = new VisitedVertex(index, vertexCount);
        // 更新出发顶点的信息
        updateVertexInfo(visitedVertex, index, matrix[index]);

        // 更新其他顶点的信息
        for (int i = 1; i < vertexCount; i++) {
            int next = visitedVertex.getNext();
            updateVertexInfo(visitedVertex, next, matrix[next]);
        }
        visitedVertex.show();
    }

    /**
     * 更新下标为index的顶点的信息
     *
     * @param index         当前顶点的下标
     * @param visitedVertex 访问顶点对象
     * @param matrix        下标为index的邻接矩阵信息
     */
    private static void updateVertexInfo(VisitedVertex visitedVertex, int index, int[] matrix) {
        int len = 0;
        for (int i = 0; i < matrix.length; i++) {
            // 计算从出发顶点到index距离 和 index到下个顶点i的距离matrix[i]
            len = matrix[i] + visitedVertex.getDistance(index);
            // 如果下标为i的顶点没有访问过，且len小于出发顶点到i的距离
            if (!visitedVertex.isVisited(i) && len < visitedVertex.getDistance(i)) {
                // 更新出发顶点到i的距离为len
                visitedVertex.updateDistance(i, len);
                // 更新i的前驱顶点为index
                visitedVertex.updatePreInfo(i, index);
            }
        }
    }
}

/**
 * 访问过的节点信息类
 */
class VisitedVertex {
    private static final int N = 10000;
    // 存储顶点是否访问过的信息
    private boolean[] visited;
    // 顶点到其他顶点的路径信息
    private int[] paths;
    // 记录下标为数组下标的顶点的前驱节点信息
    private int[] preVertex;

    /**
     * 构造方法
     *
     * @param startVertex 出发顶点的下标
     * @param vertexCount 顶点的数量
     */
    public VisitedVertex(int startVertex, int vertexCount) {
        visited = new boolean[vertexCount];
        paths = new int[vertexCount];
        preVertex = new int[vertexCount];
        // 将路径信息填充，并将出发顶点对应的路径信息置为0
        Arrays.fill(paths, N);
        paths[startVertex] = 0;

        // 设置出发顶点已访问过
        visited[startVertex] = true;
    }

    /**
     * 判断下标为index的顶点是否被访问过
     *
     * @param index
     * @return
     */
    public boolean isVisited(int index) {
        return visited[index];
    }

    /**
     * 更新出发顶点到下标为index的顶点的路径
     *
     * @param index
     * @return
     */
    public void updateDistance(int index, int len) {
        paths[index] = len;
    }

    /**
     * 更新下标为index的顶点的前驱节点为pre
     *
     * @param pre
     * @param index
     */
    public void updatePreInfo(int index, int pre) {
        preVertex[index] = pre;
    }

    /**
     * 获取出发顶点到下标为index的顶点的距离
     *
     * @param index
     * @return
     */
    public int getDistance(int index) {
        return paths[index];
    }

    /**
     * 获取下一个访问顶点的下标
     *
     * @return
     */
    public int getNext() {
        int index = 0, min = N;
        for (int i = 0; i < visited.length; i++) {
            // 如果没有访问过，取出路径权值最短的顶点的下标
            if (!visited[i] && paths[i] < min) {
                min = paths[i];
                index = i;
            }
        }
        // 标记该顶点已经被访问过
        visited[index] = true;
        return index;
    }

    public void show() {
        for (int i = 0; i < visited.length; i++) {
            System.out.print((visited[i] ? 1 : 0) + " ");
        }

        System.out.println();

        for (int i = 0; i < preVertex.length; i++) {
            System.out.print(preVertex[i] + " ");
        }
        System.out.println();

        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < paths.length; i++) {
            System.out.print(data[i] + "(" + paths[i] + ")");
        }
    }
}
package com.lzlg.graph;

import java.util.ArrayDeque;
import java.util.List;

/**
 * 图工具类
 */
public class GraphUtil {
    private GraphUtil() {
    }

    /**
     * 广度优先遍历图
     * 基本思想：
     * 1.需要使用一个队列（先进先出）保存访问过的节点顺序，
     * 用来按照这个顺序访问这些节点的邻接节点
     * 2.类似一个分层搜索的过程，访问节点A，然后访问节点A能到达的所有节点。
     * 访问过A能到达的所有节点后，从这些节点出发再次访问这些节点能到达的节点。
     * <p>
     * 算法步骤：
     * 1.访问初始节点A，并标记为已访问，加入已访问队列中
     * 2.从以访问队列中获取节点A，查找节点A的第一个邻接节点B
     * 3.如果B未访问，则标记为已访问，并加入到队列中
     * 4.然后再查找节点A的下一个邻接节点，重复步骤3，直到到达不了下一个访问节点
     * 5.从队列中取出节点B，重读2，3，4步骤
     *
     * @param graph
     */
    public static void widthFirstSearch(Graph graph) {
        // 获取图的顶点个数
        int vertexCount = graph.getVertexCount();
        // 创建标记元素是否访问过的boolean数组
        boolean[] visited = new boolean[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                doWidthSearch(visited, i, graph);
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param visited 标记是否已访问过
     * @param index   起始顶点下标
     * @param graph   图数据
     */
    private static void doWidthSearch(boolean[] visited, int index, Graph graph) {
        int vertexCount = graph.getVertexCount();
        int[][] edges = graph.getEdges();
        // 标记为已访问过
        List<String> vertexList = graph.getVertexList();
        System.out.print(vertexList.get(index) + "=>");
        visited[index] = true;

        // 入队
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(index);

        while (!queue.isEmpty()) {
            int currentIndex = queue.removeFirst();
            // 获取当前节点的下一个邻接节点
            int nextIndex = getFirstNeighbor(currentIndex, vertexCount, edges);
            while (nextIndex != -1) { // 如果找到该邻接节点
                if (!visited[nextIndex]) { // 如果没有访问过，则输出访问，并入队
                    System.out.print(vertexList.get(nextIndex) + "=>");
                    visited[nextIndex] = true;
                    queue.addLast(nextIndex);
                }
                // 如果已经访问过，则获取当前节点下标的下一个邻接节点（绕过已访问的nextIndex节点）
                nextIndex = getNextNeighbor(currentIndex, nextIndex, vertexCount, edges);
            }
        }
    }


    /**
     * 深度优先遍历图
     * 基本思想：
     * 1.从初始访问节点A出发，策略是首先访问第一个邻接节点B，然后
     * 再以这个被访问过的邻接节点B作为初始节点，访问它的第二个邻接节点C，
     * 可以这样理解：每次都在访问完当前节点后首先访问当前节点的第一个邻接节点
     * 2.这样的访问策略是往纵向挖掘深入，而不是对节点的所有邻接节点进行横向访问
     * 3.深度优先搜索是一个递归的过程
     * <p>
     * 算法步骤：
     * 1.访问初始节点A，标记为已访问
     * 2.查找节点A的第一个邻接节点B
     * 3.如果B存在，如果没有被访问，则标记为已访问。
     * 并以B节点为初始访问节点，访问下一个邻接节点C
     * 4.如果B不存在，则返回初始节点A，查找节点A的第二个邻接节点
     * 5.继续递归查找节点的下一个邻接节点
     *
     * @param graph
     */
    public static void depthFirstSearch(Graph graph) {
        // 获取图的顶点个数
        int vertexCount = graph.getVertexCount();
        // 创建标记元素是否访问过的boolean数组
        boolean[] visited = new boolean[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                doDepthSearch(visited, i, graph);
            }
        }

    }

    /**
     * 深度优先遍历
     *
     * @param visited 标记是否已经访问过
     * @param index   起始顶点下标
     * @param graph   图数据
     */
    private static void doDepthSearch(boolean[] visited, int index, Graph graph) {
        List<String> vertexList = graph.getVertexList();
        int vertexCount = graph.getVertexCount();
        int[][] edges = graph.getEdges();
        // 标记该顶点已经访问过
        System.out.print(vertexList.get(index) + "->");
        visited[index] = true;

        // 找到下一个邻接顶点下标
        int nextIndex = getFirstNeighbor(index, vertexCount, edges);
        while (nextIndex != -1) {
            if (!visited[nextIndex]) { // 如果该节点没有被访问过，则当作新的访问起点进行查找
                doDepthSearch(visited, nextIndex, graph);
            }
            // 如果已经访问过，则获取下一个可访问的顶点下标
            nextIndex = getNextNeighbor(index, nextIndex, vertexCount, edges);
        }
    }

    /**
     * 获取下标为index的节点的第一个节点下标
     *
     * @param index       起点节点下标
     * @param vertexCount 节点数量
     * @param edges       图的邻接矩阵
     * @return
     */
    private static int getFirstNeighbor(int index, int vertexCount, int[][] edges) {
        for (int i = 0; i < vertexCount; i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取下标为index1顶点的一个邻接index2顶点（已经被访问过）的下一个可访问的邻接节点的下标
     * 举例：顶点C到不到顶点D，只能重回顶点B进行访问D。
     * 从B再次访问时要经过C，而这时C已经访问过，借助此方法找到B能到达D的下标
     *
     * @param index1      起始顶点
     * @param index2      已访问过的顶点
     * @param vertexCount 顶点数量
     * @param edges       图的邻接矩阵
     * @return
     */
    public static int getNextNeighbor(int index1, int index2, int vertexCount, int[][] edges) {
        for (int i = index2 + 1; i < vertexCount; i++) {
            if (edges[index1][i] > 0) {
                return i;
            }
        }
        return -1;
    }
}

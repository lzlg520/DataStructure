package com.lzlg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图：多对多关系的表示
 * 图是一种数据结构，其中节点可以具有零个或多个相邻元素，
 * 两个节点直接的链接成为边，节点也可称为顶点。
 * 常见概念：
 * 1.顶点（vertex） 2.边（edge）
 * 3.路径 从一个顶点到另一个顶点的路线
 * 4.无向图：顶点之间的链接没有方向，A->B 也可以是 B->A
 * 5.有向图：顶点之间的链接有方向，A->B只能表示为 A->B
 * 6.带权图：边带权值的图
 * <p>
 * 图的表示方式：
 * 1.二维数组（邻接矩阵）
 * 2.数组+链表 数组存放元素，链表存储数组中的元素相关联的顶点列表
 */
public class Graph {
    // 存储顶点集合
    private List<String> vertexList;
    // 存储表示图的邻接矩阵
    private int[][] edges;
    // 边的数量
    private int edgeCount;

    /**
     * 构造方法
     *
     * @param vertexCount 顶点个数
     */
    public Graph(int vertexCount) {
        vertexList = new ArrayList<>(vertexCount);
        edges = new int[vertexCount][vertexCount];
    }

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int getVertexCount() {
        return vertexList.size();
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int getEdgeCount() {
        return edgeCount;
    }

    /**
     * 返回下标为index的Vertex的值
     *
     * @param index
     * @return
     */
    public String getVertexValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回两个顶点的权值
     *
     * @param vertex1
     * @param vertex2
     * @return
     */
    public int getWeight(String vertex1, String vertex2) {
        int index1 = vertexList.indexOf(vertex1);
        if (index1 == -1) {
            throw new RuntimeException("不存在顶点值：" + vertex1);
        }
        int index2 = vertexList.indexOf(vertex2);
        if (index2 == -1) {
            throw new RuntimeException("不存在顶点值：" + vertex2);
        }
        return edges[index1][index2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 添加顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 批量添加顶点
     *
     * @param array
     */
    public void batchInsertVertex(String[] array) {
        for (int i = 0; i < array.length; i++) {
            insertVertex(array[i]);
        }
    }

    /**
     * 添加边
     *
     * @param vertex1 顶点值1
     * @param vertex2 顶点值2
     */
    public void insertEdge(String vertex1, String vertex2) {
        int index1 = vertexList.indexOf(vertex1);
        if (index1 == -1) {
            throw new RuntimeException("不存在顶点值：" + vertex1);
        }
        int index2 = vertexList.indexOf(vertex2);
        if (index2 == -1) {
            throw new RuntimeException("不存在顶点值：" + vertex2);
        }
        // 1 表示 两个顶点直接关联，0 表示不关联
        edges[index1][index2] = 1;
        edges[index2][index1] = 1;
        // 边的数量+1
        edgeCount++;
    }

    public int[][] getEdges() {
        return edges;
    }

    public List<String> getVertexList() {
        return vertexList;
    }
}

package com.lzlg.graph;

public class GraphTest {
    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(array.length);
        // 1.添加顶点
        graph.batchInsertVertex(array);
        // 2.添加边
        graph.insertEdge("1", "2");
        graph.insertEdge("1", "3");
        graph.insertEdge("2", "4");
        graph.insertEdge("2", "5");
        graph.insertEdge("3", "6");
        graph.insertEdge("3", "7");
        graph.insertEdge("4", "8");
        graph.insertEdge("5", "8");
        graph.insertEdge("6", "7");

        graph.showGraph();
        System.out.println("图的深度优先遍历：");
        GraphUtil.depthFirstSearch(graph);

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("图的广度优先遍历：");
        GraphUtil.widthFirstSearch(graph);
    }
}

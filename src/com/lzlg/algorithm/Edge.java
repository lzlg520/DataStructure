package com.lzlg.algorithm;

/**
 * 边
 */
public class Edge implements Comparable<Edge> {
    private char start; // 边的一个顶点
    private char end;   // 边的另一个顶点
    private int weight; // 边的权值

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "边<" + start + "->" + end + ">的权值=" + weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    public char getStart() {
        return start;
    }

    public char getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}

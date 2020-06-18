package com.graphs;

public interface Graph {
    void addEdge(Integer src, Integer dest);

    void printDFS(int startingVertex);

    void printDFSRecur(int startingVertex);

    void printBFS(int startingVertex);

    boolean isCyclic();

}

package com.graphs;

import java.util.List;

public interface Graph<T> {
    void addEdge(T src, T dest);

    //    void printDFS(int startingVertex);

    //    void printDFSRecur(int startingVertex);

    //    void printBFS(int startingVertex);

    List<Node<T>> getAdjacent(T vertex);

    Node<T> getNode(T vertex);

    List<Node<T>> traverse(T startingNode, GraphTraversal<T> graphTraversal);

    boolean isCyclic();

}

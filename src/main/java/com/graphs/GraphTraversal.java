package com.graphs;

import java.util.List;

public interface GraphTraversal<T> {
    List<Node<T>> traverse(Graph<T> graph, T startingVertex);
}

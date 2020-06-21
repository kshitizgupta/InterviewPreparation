package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSTraversal<T> implements GraphTraversal<T> {

    @Override
    public List<Node<T>> traverse(final Graph<T> graph, final T startingVertex) {
        List<Node<T>> traversalOrder = new ArrayList<>();

        Queue<T> queue = new LinkedList<>();
        queue.offer(startingVertex);

        Set<T> visited = new HashSet<>();
        visited.add(startingVertex);

        while (!queue.isEmpty()) {
            T popped = queue.poll();
            traversalOrder.add(graph.getNode(popped));
            graph.getAdjacent(popped).forEach(node -> {
                if (!visited.contains(node.getId())) {
                    queue.offer(node.getId());
                    visited.add(node.getId());
                }
            });
        }
        return traversalOrder;
    }
}

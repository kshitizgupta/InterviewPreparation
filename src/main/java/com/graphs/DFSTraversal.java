package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFSTraversal<T> implements GraphTraversal<T> {
    @Override
    public List<Node<T>> traverse(final Graph<T> graph, final T startingVertex) {
        List<Node<T>> output = new ArrayList<>();
        traverseHelper(graph, startingVertex, new HashSet<T>(), new Stack<T>(), output);
        return output;
    }

    private void traverseHelper(final Graph<T> graph, final T currVertex, final Set<T> visited, final Stack<T> stk, List<Node<T>> output) {
        visited.add(currVertex);
        output.add(graph.getNode(currVertex));
        graph.getAdjacent(currVertex).forEach(node -> {
            if(!visited.contains(node.getId())) {
                stk.push(node.getId());
                traverseHelper(graph, node.getId(), visited, stk, output);
            }
        });
    }
}

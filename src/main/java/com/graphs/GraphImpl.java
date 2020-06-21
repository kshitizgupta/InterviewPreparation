package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl<T> implements Graph<T> {
    private final Map<T, List<Node<T>>> map;
    private final Map<T, Node<T>> nodes;

    public GraphImpl() {
        map = new HashMap<>();
        nodes = new HashMap<>();
    }

    @Override
    public void addEdge(final T src, final T dest) {
        Node<T> destN = new Node<>(dest);
        Node<T> srcN = new Node<>(src);
        if (!nodes.containsKey(src)) {
            nodes.put(src, srcN);
        }
        if (!nodes.containsKey(dest)) {
            nodes.put(dest, destN);
        }
        if (!map.containsKey(src)) {
            map.put(src, new ArrayList<>());
        }
        map.get(src).add(destN);
    }

    @Override
    public List<Node<T>> getAdjacent(T vertex) {
        return map.get(vertex);
    }

    @Override
    public Node<T> getNode(T vertex) {
        return nodes.get(vertex);
    }

    @Override
    public List<Node<T>> traverse(final T startingNode, GraphTraversal<T> graphTraversal) {
        return graphTraversal.traverse(this, startingNode);
    }

    @Override
    public boolean isCyclic() {
        return false;
    }
}

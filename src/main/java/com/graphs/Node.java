package com.graphs;

public class Node<T> {
    private final T data;

    public Node(final T data) {
        this.data = data;
    }

    public T getId() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}

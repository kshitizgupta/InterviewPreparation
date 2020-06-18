package com.trees;

public class Node {
    protected int data;
    protected Node left;
    protected Node right;

    public Node(final int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}

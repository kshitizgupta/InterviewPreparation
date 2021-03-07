package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphOnList {
    ArrayList<LinkedList<Integer>> vertices;

    public GraphOnList(int size) {
        this.vertices = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            vertices.add(new LinkedList<>());
        }
    }

    public void addEdge(final Integer src, final Integer dest) {
        vertices.get(src).offer(dest);
        vertices.get(dest).offer(src);
    }

    public void printBFS(int startingVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startingVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            visited.add(currentVertex);
            System.out.print(currentVertex + " --> ");
            for (int j = 0; j < vertices.get(currentVertex).size(); j++) {
                if (!visited.contains(vertices.get(currentVertex).get(j))) {
                    queue.offer(vertices.get(currentVertex).get(j));
                }
            }

        }
    }

    public void printDFS(int startingIndex) {
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack();
        stack.push(startingIndex);
        visited.add(startingIndex);
        System.out.print(startingIndex + "-->");

        while (!stack.isEmpty()) {
            int current = stack.peek();
            int flag = 0;
            for (int i = 0; i < vertices.get(current).size(); i++) {
                Integer currentVertex = vertices.get(current).get(i);
                if (!visited.contains(currentVertex)) {
                    visited.add(currentVertex);
                    stack.push(currentVertex);
                    flag = 1;
                    System.out.print(currentVertex + "-->");
                    break;
                }
            }
            if (flag == 0) {
                stack.pop();
            }
        }
    }

    public void printDFSRecur(int startingIndex) {
        Set<Integer> visited = new HashSet<Integer>();
        printDFSUtil(startingIndex, visited);
    }

    private void printDFSUtil(final int startingIndex, final Set<Integer> visited) {
        System.out.print(startingIndex + "-->");
        visited.add(startingIndex);
        for (int i = 0; i < vertices.get(startingIndex).size(); i++) {
            Integer currentVertex = vertices.get(startingIndex).get(i);
            if (!visited.contains(currentVertex)) {
                printDFSUtil(currentVertex, visited);
            }
        }
    }

    public boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < vertices.size(); i++) {
            if (!visited.contains(i)) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(final int currentIndex, final Set<Integer> visited, final int parent) {

        visited.add(currentIndex);
        for (int i = 0; i < vertices.get(currentIndex).size(); i++) {
            Integer newVertex = vertices.get(currentIndex).get(i);
            if (!visited.contains(newVertex)) {
                if (isCyclicUtil(newVertex, visited, newVertex))
                    return true;
            } else if (parent != newVertex) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphOnList graph = new GraphOnList(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        //        graph.addEdge(0, 3);
        graph.addEdge(0, 4);

        System.out.println(graph.isCyclic());
    }

}

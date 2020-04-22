package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphOnArray implements Graph {
    private LinkedList<Integer> graph[];

    public GraphOnArray(int size) {
        graph = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(final Integer src, final Integer dest) {
        if (graph[src] == null) {
            graph[src] = new LinkedList<Integer>();
        }

        graph[src].add(dest);

    }

    @Override
    public void printDFS(final int startingVertex) {
    }

    @Override
    public void printDFSRecur(final int startingVertex) {
        Set<Integer> visited = new HashSet<>();
        printDFSRecurUtil(startingVertex, visited);
    }

    private void printDFSRecurUtil(int currentVertex, Set<Integer> visited) {
        if (visited.contains(currentVertex)) {
            return;
        }

        visited.add(currentVertex);
        System.out.print(currentVertex + "-->");

        for (int i = 0; i < graph[currentVertex].size(); i++) {
            printDFSRecurUtil(graph[currentVertex].get(i), visited);
        }
    }

    @Override
    public void printBFS(final int startingVertex) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startingVertex);
        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            visited.add(currentIndex);
            System.out.print(currentIndex + "-->");
            for (int i = 0; i < graph[currentIndex].size(); i++) {
                if (!visited.contains(graph[currentIndex].get(i))) {
                    queue.offer(graph[currentIndex].get(i));
                }
            }
        }

    }

    @Override
    public boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();
        return isCyclicUtil(0, visited);
    }

    private boolean isCyclicUtil(int currentVertex, Set<Integer> visited) {
        if (visited.contains(currentVertex)) {
            return true;
        }

        visited.add(currentVertex);

        for (int i = 0; i < graph[currentVertex].size(); i++) {
            boolean hasCycles = isCyclicUtil(graph[currentVertex].get(i), visited);
            if (hasCycles) {
                return true;
            }
        }
        return false;
    }
}

package com.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Time Complexity
 *
 * V no of vertices
 * Eav average edges with each vertex
 * E total no of edges in graph = V*Eav
 *
 * The outer loop runs for a max of V times
 * V * (O(1) + O(Eav) + O(1))
 * V + V * Eav + V
 * 2V + E(total number of edges in graph)
 * V + E
 *
 * O(V + E)
 */
public class ShortestPathUnweightedGraph {
    public static List<Integer> solution(Map<Integer, List<Integer>> adjacencyMap, int src, int dest) {
        List<Integer> path = new ArrayList<>();

        Map<Integer, Integer> nodeToParentInPath = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nodeToParentInPath.put(src, -1);

        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            for (int toNode : adjacencyMap.get(polled)) {
                if (!visited.contains(toNode)) {
                    queue.offer(toNode);
                    visited.add(toNode);
                    nodeToParentInPath.put(toNode, polled);
                }
            }
        }

        if (!nodeToParentInPath.containsKey(dest)) {
            return Collections.emptyList();
        }

        int currentNodeInPath = dest;
        path.add(dest);
        while (currentNodeInPath != src) {
            int parent = nodeToParentInPath.get(currentNodeInPath);
            path.add(parent);
            currentNodeInPath = parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            adjacencyMap.put(i, new ArrayList<>());
        }
        addEdge(adjacencyMap, 0,1);

        addEdge(adjacencyMap, 0,3);

        addEdge(adjacencyMap, 1,2);

        addEdge(adjacencyMap, 3,4);

        addEdge(adjacencyMap, 3,7);

        addEdge(adjacencyMap, 4,5);

        addEdge(adjacencyMap, 4,6);

        addEdge(adjacencyMap, 4,7);

        addEdge(adjacencyMap, 5,6);

        addEdge(adjacencyMap, 6,7);

        System.out.println(solution(adjacencyMap, 0, 7));
        System.out.println(solution(adjacencyMap, 0, 6));
        System.out.println(solution(adjacencyMap, 0, 5));
        System.out.println(solution(adjacencyMap, 0, 2));
        System.out.println(solution(adjacencyMap, 5, 2));
    }

    public static void addEdge(Map<Integer, List<Integer>> adj, int src, int dest) {
        //For undirected graph adding 2 edges but for directed graph we should not do it
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
}

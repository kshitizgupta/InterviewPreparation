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
        adjacencyMap.get(0).add(1);
        adjacencyMap.get(0).add(3);
        adjacencyMap.get(1).add(2);
        adjacencyMap.get(3).add(4);
        adjacencyMap.get(3).add(7);
        adjacencyMap.get(4).add(5);
        adjacencyMap.get(4).add(6);
        adjacencyMap.get(4).add(7);
        adjacencyMap.get(5).add(6);
        adjacencyMap.get(6).add(7);

        System.out.println(solution(adjacencyMap, 0, 7));
        System.out.println(solution(adjacencyMap, 0, 6));
        System.out.println(solution(adjacencyMap, 0, 5));
        System.out.println(solution(adjacencyMap, 0, 2));
    }
}

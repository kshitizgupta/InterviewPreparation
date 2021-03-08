package com.graphs;

import java.util.*;

public class BuildOrder {
    public static List<Integer> solution(Map<Integer, List<Integer>> adjMap) {
        List<Integer> buildOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        adjMap.forEach((k, v) -> {
            if (!visited.contains(k)) {
                dfs(adjMap, visited, buildOrder, k);
            }
        });
        return buildOrder;
    }

    private static void dfs(final Map<Integer, List<Integer>> adjMap, final Set<Integer> visited, final List<Integer> buildOrder, final Integer src) {
        visited.add(src);
        for (int adj : adjMap.get(src)) {
            if (!visited.contains(adj)) {
                dfs(adjMap, visited, buildOrder, adj);
            }
        }
        buildOrder.add(src);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        adjMap.get(4).add(0);
        adjMap.get(4).add(1);
        adjMap.get(3).add(1);
        adjMap.get(2).add(3);
        adjMap.get(5).add(2);
        adjMap.get(5).add(0);

        System.out.println(solution(adjMap));
    }
}

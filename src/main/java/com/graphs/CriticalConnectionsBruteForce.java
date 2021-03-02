package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach
 * any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 */
public class CriticalConnectionsBruteForce {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> criticalConnections = new ArrayList<>();
        List<List<Integer>> graph = constructGraph(connections, n);
        for (int i = 0; i < connections.size(); i++) {
            if (isCritical(i, connections, n, graph)) {
                criticalConnections.add(connections.get(i));
            }
        }

        return criticalConnections;
    }

    public static boolean isCritical(int skipConnection, List<List<Integer>> connections, int n, final List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int skipFrom = connections.get(skipConnection).get(0);
        int skipTo = connections.get(skipConnection).get(1);

        queue.offer(0);

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            visited.add(polled);
            for (Integer node : graph.get(polled)) {
                if ((skipFrom == polled && skipTo == node) || (skipTo == polled && skipFrom == node)) {
                    continue;
                }
                if (!visited.contains(node)) {
                    queue.add(node);
                }
            }
        }

        return visited.size() != n;

    }

    public static List<List<Integer>> constructGraph(List<List<Integer>> connections, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.add(0, new ArrayList<>());
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        return graph;
    }

    public static void main(String[] args) {
        //[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
        List<List<Integer>> connections = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(1);
                add(0);
            }});
            add(new ArrayList<>() {{
                add(2);
                add(0);
            }});
            add(new ArrayList<>() {{
                add(3);
                add(2);
            }});
            add(new ArrayList<>() {{
                add(4);
                add(2);
            }});
            add(new ArrayList<>() {{
                add(4);
                add(3);
            }});
            add(new ArrayList<>() {{
                add(3);
                add(0);
            }});
            add(new ArrayList<>() {{
                add(4);
                add(0);
            }});
        }};

        System.out.println("Output" + criticalConnections(5, connections));
    }

}

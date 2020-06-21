package com.graphs;

import java.util.List;

public class GraphApplication {
    public static void main(String[] args) {
        System.out.println("********Testing Graph type ");

        final Graph<Integer> integerGraph = getGraph();
        final GraphTraversal<Integer> bfsTraversal = new BFSTraversal<>();
        final GraphTraversal<Integer> dfsTraversal = new DFSTraversal<>();
        List<Node<Integer>> bfsTraversalOutput = integerGraph.traverse(0, bfsTraversal);
        List<Node<Integer>> dfsTraversalOutput = integerGraph.traverse(0, dfsTraversal);

        System.out.println("BFS = " + bfsTraversalOutput);
        System.out.println("DFS = " + dfsTraversalOutput);

        //        System.out.println("\n\n********Testing Graph type " + GraphOnList.class.getName());
        //        test(getGraph("2"), getNoCycleGraph("2"));
    }

    //    private static void test(final Graph graph, final Graph aCyclicGraph) {
    //
    //        System.out.println("\n1.Following is Breadth First Traversal " +
    //            "(starting from vertex 2)");
    //        graph.printBFS(2);
    //
    //        System.out.println("\n2.Following is Depth First Traversal Recursively" +
    //            "(starting from vertex 2)");
    //        graph.printDFSRecur(2);
    //
    //        System.out.println("\nShould have cycles. Has ? " + (graph.isCyclic() ? "Yes" : "No"));
    //
    //        System.out.println("\nShould not have cycles, Has ? " + (aCyclicGraph.isCyclic() ? "Yes" : "No"));
    //    }
    //
    //    private static Graph getNoCycleGraph(String type) {
    //        Graph g = graphConstructor(type, 5);
    //        g.addEdge(0, 1);
    //        g.addEdge(1, 2);
    //        return g;
    //    }
    //
    private static Graph<Integer> getGraph() {
        Graph<Integer> g = new GraphImpl<>();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 3);
        g.addEdge(3, 5);
        return g;
    }
}

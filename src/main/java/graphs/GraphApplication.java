package graphs;

public class GraphApplication {
    public static void main(String[] args) {
        System.out.println("********Testing Graph type " + GraphOnList.class.getName());
        test(getGraph("1"), getNoCycleGraph("1"));

        System.out.println("\n\n********Testing Graph type " + GraphOnList.class.getName());
        test(getGraph("2"), getNoCycleGraph("2"));
    }

    private static void test(final Graph graph, final Graph aCyclicGraph) {

        System.out.println("\n1.Following is Breadth First Traversal " +
            "(starting from vertex 2)");
        graph.printBFS(2);

        System.out.println("\n2.Following is Depth First Traversal Recursively" +
            "(starting from vertex 2)");
        graph.printDFSRecur(2);

        System.out.println("\nShould have cycles. Has ? " + (graph.isCyclic() ? "Yes" : "No"));

        System.out.println("\nShould not have cycles, Has ? " + (aCyclicGraph.isCyclic() ? "Yes" : "No"));
    }

    private static Graph getNoCycleGraph(String type) {
        Graph g = graphConstructor(type, 5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        return g;
    }

    private static Graph getGraph(String type) {
        Graph g = graphConstructor(type, 4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }

    private static Graph graphConstructor(String type, int size) {
        switch (type) {
            case "1":
                return new GraphOnList(size);
            case "2":
                return new GraphOnArray(size);
            default:
                throw new UnsupportedOperationException();
        }
    }
}

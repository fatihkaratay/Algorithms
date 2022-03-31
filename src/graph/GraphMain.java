package graph;

import java.util.List;

public class GraphMain {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("1");
        g.addNode("0");

        g.addEdge("1", "0");
        g.addEdge("0", "1");

        g.print();

        List<String> list = g.topoSort();
        System.out.println(list);

        System.out.println(g.hasCycle());
    }
}

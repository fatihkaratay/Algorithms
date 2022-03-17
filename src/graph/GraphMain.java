package graph;

import java.util.List;

public class GraphMain {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("X");
        g.addNode("A");
        g.addNode("B");
        g.addNode("P");

        g.addEdge("X", "A");
        g.addEdge("X", "B");
        g.addEdge("A", "P");
        g.addEdge("B", "P");

        List<String> topoSortList = g.topoSort();

        System.out.println(topoSortList);
    }
}

package graph;

public class GraphMain {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");

        g.addEdge("A", "B");
        g.addEdge("C", "D");
        g.addEdge("C", "A");
        g.addEdge("D", "B");

        g.print();
    }
}

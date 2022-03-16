package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adList.get(fromNode).add(toNode);

    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) return;

        for (Node n : adList.keySet())
            adList.get(n).remove(node);

        adList.remove(node);
        nodes.remove(node);
    }

    public void print() {
        for (Node source : adList.keySet()) {
            List<Node> targets = adList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + "->" + targets);
            }
        }
    }

}

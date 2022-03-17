package graph;

import java.util.*;

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

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) return;

        adList.get(fromNode).remove(toNode);
    }

    public void dfs(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        dfs(node, new HashSet<>());
    }
    private void dfs(Node root, Set<Node> visited) {
        System.out.print(root + " ");
        visited.add(root);

        for (Node node : adList.get(root))
            if (!visited.contains(node))
                dfs(node, visited);
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

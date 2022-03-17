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

    public void dfsRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        dfsRec(node, new HashSet<>());
    }
    private void dfsRec(Node root, Set<Node> visited) {
        System.out.print(root + " ");
        visited.add(root);

        for (Node node : adList.get(root))
            if (!visited.contains(node))
                dfsRec(node, visited);
    }

    public void dfsItr(String label) {
        Node root = nodes.get(label);
        if (root == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.contains(current))
                continue;
            System.out.print(current + " ");
            visited.add(current);

            for (Node n : adList.get(current))
                if (!visited.contains(n))
                    stack.push(n);
        }
    }

    public void bfs(String label) {
        Node root = nodes.get(label);
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Set<Node> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Node current = q.remove();
            if (visited.contains(current))
                continue;
            System.out.print(current + " ");
            visited.add(current);

            for (Node n : adList.get(current))
                if (!visited.contains(n))
                    q.offer(n);
        }
    }

    public List<String> topoSort() {
        List<String> res = new ArrayList<>();
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node node : nodes.values())
            topoSort(node, set, stack);

        while (!stack.isEmpty())
            res.add(stack.pop().label);

        return res;
    }
    private void topoSort(Node node, Set<Node> set, Stack<Node> stack) {
        if (set.contains(node))
            return;
        set.add(node);

        for (Node n : adList.get(node))
            topoSort(n, set, stack);

        stack.push(node);
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

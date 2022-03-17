package graph;

public class Node {
    String label;

    public Node(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

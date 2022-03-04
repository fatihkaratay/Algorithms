package binarytree;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(6);
        root.left.right = new Node(21);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(8);
        root.right.left = new Node(4);

        System.out.println(height(root));
    }

    public static int height(Node node) {
        // base case
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}

package binarytree;

public class DFS {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right = new Node(9);
        root.right.left = new Node(8);
        root.right.right = new Node(10);

        preOrderTraversal(root);
    }

    // root-left-right
    public static void preOrderTraversal(Node node) {
        // base case
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}

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
        System.out.println();

        inOrderTraversal(root);
        System.out.println();

        postOrderTraversal(root);
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

    // left-root-right
    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    // left-right-root
    public static void postOrderTraversal(Node node) {
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }
}

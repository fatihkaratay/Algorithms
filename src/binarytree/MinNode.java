package binarytree;

/**
 * Finding the min value of the node in a Binary Tree.
 */

public class MinNode {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(6);
        root.left.right = new Node(21);
        root.right.left = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(8);

        System.out.println(minNode(root));
    }

    public static int minNode(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;;
        // get min of left subtree, min of right subtree, compare it with the root node.
        int left = minNode(node.left);
        int right = minNode(node.right);

        return Math.min(Math.min(left, right), node.val);
    }
}

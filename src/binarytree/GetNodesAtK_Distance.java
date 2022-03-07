package binarytree;

/**
 * Getting the nodes at distance K from the root,
 * And storing them to a list.
 */

public class GetNodesAtK_Distance {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(6);
        root.left.right = new Node(21);
        root.right.left = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(8);

        printNodesAtK_Distance(root, 3);

    }

    public static void printNodesAtK_Distance(Node root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.print(root.val + " ");

        printNodesAtK_Distance(root.left, k-1);
        printNodesAtK_Distance(root.right, k-1);
    }
}

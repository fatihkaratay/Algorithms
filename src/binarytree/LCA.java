package binarytree;

/**
 * finding the lowest common ancestor of given 2 Nodes in Binary Tree.
 */
public class LCA {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(11);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(5);

        root.right = new Node(8);
        root.right.right = new Node(13);
        root.right.right.left = new Node(7);

        System.out.println(LCA(root, new Node(2), new Node(8))); // 3
        System.out.println(LCA(root, new Node(2), new Node(5))); // 6
        System.out.println(LCA(root, new Node(9), new Node(5))); // 11
        System.out.println(LCA(root, new Node(8), new Node(7))); // 8
        System.out.println(LCA(root, new Node(9), new Node(3))); // 3
    }

    public static Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        if (root == n1 || root == n2) return root;
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) return root;
        if (left == null && right == null) return null;

        return left != null ? left : right;
    }
}

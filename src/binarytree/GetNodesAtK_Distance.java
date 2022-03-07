package binarytree;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> list = new ArrayList<>();
        getNodesAtK_Distance(root, list, 2);

        System.out.println(list);

    }

    public static void getNodesAtK_Distance(Node root, List<Integer> list, int k) {
        if (root == null)
            return;
        if (k == 0) {
            list.add(root.val);
            return;
        }

        getNodesAtK_Distance(root.left, list, k-1);
        getNodesAtK_Distance(root.right, list, k-1);
    }
}

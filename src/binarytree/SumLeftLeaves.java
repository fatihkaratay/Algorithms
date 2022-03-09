package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * sum of only the left leaves in a binary tree.
 */

public class SumLeftLeaves {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.right = new Node(7);
        root.right.left = new Node(15);

        System.out.println(sumLeftLeaveNodes(root));
        printLeafNodes(root);
    }

    public static int sumLeftLeaveNodes(Node root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val += sumLeftLeaveNodes(root.right);
        else
            return sumLeftLeaveNodes(root.left) + sumLeftLeaveNodes(root.right);
    }


    static void printLeafNodes(Node root) {
        // If node is null, return
        if (root == null)
            return;

        // If node is leaf node, print its data
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }

        // If left child exists, check for leaf
        // recursively
        if (root.left != null)
            printLeafNodes(root.left);

        // If right child exists, check for leaf
        // recursively
        if (root.right != null)
            printLeafNodes(root.right);
    }
}

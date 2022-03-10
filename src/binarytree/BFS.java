package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * traversing the binary tree and printing the nodes from
 * top to bottom
 * from left side only
 * from right side only.
 */

public class BFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);

        List<Integer> list1 = topDownView(root);
        List<Integer> list2 = leftSideView(root);
        List<Integer> list3 = rightSideView(root);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

    public static List<Integer> rightSideView(Node root) {
        return null;
    }
    public static List<Integer> leftSideView(Node root) {
        return null;
    }
    public static List<Integer> topDownView(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.poll();
            list.add(root.val);

            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
        }

        return list;
    }
}

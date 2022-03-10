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
        List<Integer> list4 = bottomView(root); // leave Nodes

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
    }

    public static List<Integer> rightSideView(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for (int i = 0; i < levelLength; ++i) {
                Node node = queue.poll();
                // if it's the rightmost element
                if (i == levelLength - 1) list.add(node.val);

                // add child nodes in the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return list;
    }

    public static List<Integer> leftSideView(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                // if it's the leftmost element
                if (i == 0) list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return list;
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

    public static List<Integer> bottomView(Node root) {
        List<Integer> list = new ArrayList<>();
        bottomView(root, list);

        return list;
    }

    public static void bottomView(Node root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null )
            bottomView(root.left, list);
        if (root.right != null)
            bottomView(root.right, list);
    }
}

package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Printing the nodes by their levels.
 */

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(6);
        root.left.right = new Node(21);
        root.right.left = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(8);

        levelOrderTraversal(root);
        System.out.println();

        List<List<Integer>> list = levelOrderEachLevel(root);
        System.out.println(list);
    }

    public static void levelOrderTraversal(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static List<List<Integer>> levelOrderEachLevel(Node node) {
        List<List<Integer>> res = new ArrayList<>();
        if (node == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                list.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(list);
        }
        return res;
    }
}

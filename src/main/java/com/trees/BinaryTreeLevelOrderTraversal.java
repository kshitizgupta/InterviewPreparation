package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal implements BinaryTreeView {

    private static final String NAME = "Level Order Traversal";

    public void print(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Node> currentLevel = new ArrayList<>();

        while (true) {
            final Node polled = queue.poll();

            if (polled == null) {
                System.out.println(currentLevel);

                if (queue.isEmpty()) {
                    break;
                }

                currentLevel.clear();
                queue.offer(null);
            } else {

                currentLevel.add(polled);

                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public static void main(String[] args) {
        BinarySearchTree.getBSTForTesting().print(new BinaryTreeLevelOrderTraversal());
    }

}

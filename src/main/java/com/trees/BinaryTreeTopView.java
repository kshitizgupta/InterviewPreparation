package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTopView implements BinaryTreeView {
    @Override
    public void print(final Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        Node prev = null;
        Node first = null;
        boolean isEndOfLevel = false;
        boolean isStartOfLevel = true;

        while (!queue.isEmpty()) {
            Node popped = queue.poll();

            if (popped == null) {

                first = queue.peek();

                if (first == null)
                    break;
                System.out.print("" + prev + first);
                queue.offer(null);

            } else {

                prev = popped;

                if (popped.left != null) queue.offer(popped.left);
                if (popped.right != null) queue.offer(popped.right);
            }
        }

    }

    @Override
    public String getName() {
        return "Binary Tree Top View";
    }

    public static void main(String[] args) {
        BinarySearchTree.getBSTForTesting().print(new BinaryTreeTopView());
    }
}

package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSpiralTraversal implements BinaryTreeView {
    private final String NAME = "SPIRAL TRAVERSAL";

    public String getNAME() {
        return NAME;
    }

    public void print(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Node> currentLevelList = new ArrayList<>();
        boolean isOddLevel = true;

        while (true) {
            final Node polled = queue.poll();

            if (polled == null) {
                printLevelHelper(currentLevelList, !isOddLevel);

                if (queue.isEmpty()) {
                    break;
                }

                currentLevelList.clear();
                isOddLevel = !isOddLevel;
                queue.offer(null);
            } else {
                currentLevelList.add(polled);

                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    private void printLevelHelper(final List<Node> currentLevelList, boolean reverse) {
        System.out.print("\n LEVEL: ");
        if (!reverse) {
            for (Node node : currentLevelList) {
                System.out.print(node);
            }
        } else {
            for (int i = currentLevelList.size() - 1; i >= 0; i--) {
                System.out.print(currentLevelList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree.getBSTForTesting().print(new BinaryTreeSpiralTraversal());
    }
}

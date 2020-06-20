package com.trees;

public class BinarySearchTree {

    private Node root;

    protected boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node prev = null;
        boolean isLeft = false;
        while (current != null) {
            prev = current;
            if (val < current.data) {
                isLeft = true;
                current = current.left;
            } else {
                isLeft = false;
                current = current.right;
            }
        }

        if (isLeft) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
    }

    public boolean search(int val) {
        Node curr = root;

        while (curr != null) {
            if (curr.data == val) return true;

            if (val < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
    }

    public static BinarySearchTree getBSTForTesting() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        return bst;
    }

    public <T extends BinaryTreeView> void print(T printer) {
        System.out.println("Printing " + printer.getName().toUpperCase());
        printer.print(root);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);

        System.out.println(bst.search(1));
        System.out.println(bst.search(3));
        System.out.println(bst.search(4));
    }
}

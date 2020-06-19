package com.trees;

public class LCA {
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 8);
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 6);
        root = insert(root, 7);

        System.out.println(lca(root, 3, 7));
    }

    public static Node lca(Node node, int v1, int v2) {
        if (node == null) {
            return null;
        }

        if (v1 == node.data || v2 == node.data) {
            return node;
        } else if (v1 < node.data && node.data < v2) {
            return node;
        } else if (v2 < node.data && node.data < v1) {
            return node;
        } else if (v1 < node.data && v2 < node.data) {
            return lca(node.left, v1, v2);
        } else if (node.data < v1 && node.data < v2) {
            return lca(node.right, v1, v2);
        }
        return null;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

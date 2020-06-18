package com.trees;

public class IsBST {
    boolean checkBST(Node root) {
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBSTHelper(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(!(root.data < max && root.data > min)) {
            return false;
        }
        return checkBSTHelper(root.left, min, root.data) && checkBSTHelper(root.left, root.data, max);
    }
}

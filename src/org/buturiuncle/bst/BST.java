package org.buturiuncle.bst;

import java.util.Comparator;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root = null;

    private class Node {
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        private Key key;
        private Value value;
        private Node left;
        private Node right;
    }

    public void put(Key key, Value value) {
        root = this.put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp == 0) {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.value;
        }
        return null;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        Node min = x;
        while (x.left != null) {
            x = x.left;
        }
        return min;
    }

    public void inorder() {
        this.inorder(root);
    }

    private void inorder(Node x)
    {
        if(x != null) {
            inorder(x.left);
            System.out.print(x.key + " ");
            inorder(x.right);
        } else {
            return;
        }
    }

    public void preorder() {
        this.preorder(root);
    }

    private void preorder(Node x) {
        if(x != null) {
            System.out.print(x.key + " ");
            preorder(x.left);
            preorder(x.right);
        } else {
            return;
        }
    }

    public void postorder() {
        this.postorder(root);
    }

    private void postorder(Node x) {
        if(x != null) {
            postorder(x.left);
            postorder(x.right);
            System.out.print(x.key + " ");
        } else {
            return;
        }

    }
}

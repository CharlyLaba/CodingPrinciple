package src;

import java.io.*;

public class BinaryTree {

    private Node root; // hidden root node
    private String word;
    private BinaryTree left, right;

    public void insertData(String word) {
        if (root == null) { // must handle case of empty tree first
            root = new Node(word);
            return;
        }
        Node check = root; // start search downward at root
        while (true) {
            if (word.compareToIgnoreCase(check.data) < 0) { // look left
                if (check.left != null) check = check.left;
                else { check.left = new Node(word); break; }
            }
            else if (word.compareToIgnoreCase(check.data) > 0) { // look right
                if (check.right != null) check = check.right;
                else { check.right = new Node(word); break; }
            }
            else break; // found! Don't insert
        }
    }

    public void inorderTraversal(PrintWriter writer) {
        inOrder(root, writer);
    }

    // inorderT: recursive function that does the work
    private void inOrder(Node node, PrintWriter writer) {
        if (node != null) {
            inOrder(node.left, writer);
            //System.out.println(node.data+" "); <- For printing contents in order to console
            writer.println(node.data);
            inOrder(node.right, writer);
        }
    }

    public boolean containsString(String value) {
        return containsStringRecursive(root, value);
    }

    private boolean containsStringRecursive(Node root, String value) {
        if (root == null) {
            return false; // not in set
        } else if (root.data.compareTo(value) == 0) {
            return true; // found!
        } else if (root.data.compareTo(value) > 0) {
            return containsStringRecursive(root.left, value); // search left
        } else {
            return containsStringRecursive(root.right, value); // search right
        }
    }
}
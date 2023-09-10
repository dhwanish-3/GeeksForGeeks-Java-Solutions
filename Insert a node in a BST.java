import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        if (root == null) {
            root = new Node(Key);
            return root;
        }
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            prev = cur;
            if (cur.data > Key) {
                cur = cur.left;
            } else if (cur.data < Key) {
                cur = cur.right;
            } else {
                return root;
            }
        }
        if (prev != null) {
            if (prev.data > Key) {
                prev.left = new Node(Key);
            } else {
                prev.right = new Node(Key);
            }
        }
        return  root;
    }
}
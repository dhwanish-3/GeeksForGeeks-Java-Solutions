class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class Solution {
    public static int floor(Node root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.data <= x && root.right == null) {
            return root.data;
        }
        int sol = -1;
        Node cur = root;
        while (cur != null) {
            if (cur.data == x) {
                return x;
            }
            if (x > cur.data) {
                sol = cur.data;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return sol;
    }
}
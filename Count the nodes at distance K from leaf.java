import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    int printKDistantfromLeaf(Node root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.remove();
                if (solve(curr, k)) {
                    count++;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return count;
    }

    public static boolean solve(Node root, int k) {
        if (root == null) {
            return false;
        }
        if ((root.left == null && root.right == null) && k == 0) {
            return true;
        }
        if ((root.left == null && root.right == null)) {
            return false;
        }
        boolean l = solve(root.left, k - 1);
        boolean r = solve(root.right, k - 1);
        return l || r;
    }
}

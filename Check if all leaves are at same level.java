import java.util.HashSet;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    HashSet<Integer> set = new HashSet<>();

    boolean check(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        solve(root.left, 1);
        solve(root.right, 1);
        return (set.size() == 1);
    }

    private void solve(Node root, int h) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            set.add(h);
            return;
        }
        solve(root.left, h + 1);
        solve(root.right, h + 1);
    }
}

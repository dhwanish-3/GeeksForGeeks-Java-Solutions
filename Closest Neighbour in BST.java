class Node {
    int key;
    Node left, right;

    Node(int x) {
        key = x;
        left = right = null;
    }

}

class Solution {
    public static int findMaxForN(Node root, int n) {
        Node cur = root;
        int sol = -1;
        while (cur != null) {
            if (cur.key > n) {
                cur = cur.left;
            } else if (cur.key <= n) {
                sol = cur.key;
                cur = cur.right;
            }
        }
        return sol;
    }
}
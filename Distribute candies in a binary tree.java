
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution
{
    private static int solve(Node root, int[] moves) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left, moves);
        int right = solve(root.right, moves);
        moves[0] += Math.abs(left) + Math.abs(right);
        return root.data + left + right - 1;
    }
    public static int distributeCandy(Node root)
    {
        int[] sol = new int[1];
        solve(root, sol);
        return sol[0];
    }
}
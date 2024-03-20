class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Solution {
    private int maxLevel = 0, sol = 0;

    private void helper(Node root, int curSum, int curLevel) {
        if (root == null) {
            return;
        }
        curSum += root.data;
        if (curLevel + 1 > maxLevel) {
            sol = curSum;
            maxLevel = curLevel + 1;
        } else if (curLevel + 1 == maxLevel) {
            sol = Math.max(sol, curSum);
        }
        if (root.left != null) {
            helper(root.left, curSum, curLevel + 1);
        }
        if (root.right != null) {
            helper(root.right, curSum, curLevel + 1);
        }
    }

    public int sumOfLongRootToLeafPath(Node root) {
        helper(root, 0, 0);
        return sol;
    }
}

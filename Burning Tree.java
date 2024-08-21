class Solution
{
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
    
    public static int minTime(Node root, int target) {
        int[] maxDistance = new int[1];  // This will store the maximum time required
        findTarget(root, target, maxDistance);
        return maxDistance[0];
    }

    private static int findTarget(Node root, int target, int[] maxDistance) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            // Start burning from the target node
            maxDistance[0] = Math.max(maxDistance[0], height(root.left));
            maxDistance[0] = Math.max(maxDistance[0], height(root.right));
            return 1;  // Distance from target node to its parent
        }
        int leftDist = findTarget(root.left, target, maxDistance);
        if (leftDist != -1) {
            // Target found in left subtree
            maxDistance[0] = Math.max(maxDistance[0], leftDist + height(root.right));
            return leftDist + 1;
        }
        int rightDist = findTarget(root.right, target, maxDistance);
        if (rightDist != -1) {
            // Target found in right subtree
            maxDistance[0] = Math.max(maxDistance[0], rightDist + height(root.left));
            return rightDist + 1;
        }
        return -1;
    }
    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
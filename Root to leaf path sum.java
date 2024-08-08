class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution {
    boolean rec(Node root, int target, int sum) {
        if (root != null) {
            sum += root.data;
            if (root.left == null && root.right == null) {
                if (sum == target) {
                    return true;
                }
            }
            if (rec(root.left, target, sum)) {
                return true;
            }
            if (rec(root.right, target, sum)) {
                return true;
            }
        }
        return false;
    }
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        // Your code here
        return rec(root, target, 0);
    }
}
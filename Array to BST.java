class Node {
    int val;
    Node left, right;
    Node(int data) {
        val = data;
        left = right = null;
    }
}

class Solution {
    private Node rec(int[] nums, int l, int r) {
        if (l < r - 1) {
            int mid = (l + r) / 2;
            Node root = new Node(nums[mid]);
            root.left = rec(nums, l, mid - 1);
            root.right = rec(nums, mid + 1, r);
            return root;
        }
        return null;
    }
    public Node sortedArrayToBST(int[] nums) {
        // Code here
        return rec(nums, 0, nums.length - 1);
    }
}
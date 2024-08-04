class Solution {
    void inorder(Node root, List<Integer> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }
    }
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) >= arr.get(i)) {
                return false;
            }
        }
        return true;
    }
}
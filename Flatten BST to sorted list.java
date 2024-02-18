class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
        left = right = null;
    }

}

class Solution {
    Node move(Node root, Node temp) {
        if (root == null) {
            return temp;
        }
        Node left = root.left;
        Node right = root.right;
        root.left = null;
        root.right = null;
        move(left, temp).right = root;
        return move(right, root);
    }
    public Node flattenBST(Node root) {
        Node temp = new Node(0);
        move(root, temp);
        return temp.right;
    }
}

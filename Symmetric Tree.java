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

class GfG {
    public static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.data == right.data) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
}
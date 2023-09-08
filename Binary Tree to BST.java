import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}


class Solution
{
    private static Node constructBST(ArrayList<Integer> in, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        Node root = new Node(in.get(mid));
        root.left = constructBST(in, l, mid - 1);
        root.right = constructBST(in, mid + 1, r);
        return root;
    }
    private static void inorder(Node root, ArrayList<Integer> in) {
        if (root == null) {
            return;
        }
        inorder(root.left, in);
        in.add(root.data);
        inorder(root.right, in);
    }
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root)
    {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        Collections.sort(in);
        return constructBST(in, 0, in.size() - 1);
    }
}
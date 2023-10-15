import java.util.ArrayList;

class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class GfG
{
    void inorder(Node root, ArrayList<Node> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }
    Node buildBST(ArrayList<Node> arr, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        Node root = arr.get(mid);
        root.left = buildBST(arr, i, mid - 1);
        root.right = buildBST(arr, mid + 1, j);
        return root;
    }
    Node buildBalancedTree(Node root) 
    {
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root, arr);
        return buildBST(arr, 0, arr.size() - 1);
    }
}

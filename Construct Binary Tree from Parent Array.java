import java.util.ArrayList;

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        // Your code here
        int n = parent.length;
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
        Node root = null;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = nodes.get(i);
            } else {
                Node par = nodes.get(parent[i]);
                if (par.left == null) {
                    par.left = nodes.get(i);
                } else {
                    par.right = nodes.get(i);
                }
            }
        }
        return root;
    }
}

import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

};

class Solution
{
    void inorder(Node root, ArrayList<Integer> in) {
        if (root != null) {
            inorder(root.left, in);
            in.add(root.data);
            inorder(root.right, in);
        }
    }
    
    int absolute_diff(Node root)
    {
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        int sol = Integer.MAX_VALUE;
        for (int i = 1; i < in.size(); i++) {
            sol = Math.min(sol, Math.abs(in.get(i) - in.get(i - 1)));
        }
        return sol;
    }
}
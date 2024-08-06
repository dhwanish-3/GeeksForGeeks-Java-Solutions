class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class Solution {
    private void inorder(Node root, List<Integer> bst) {
        if (root != null) {
            inorder(root.left, bst);
            bst.add(root.data);
            inorder(root.right, bst);
        }
    }
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> bst1 = new ArrayList<>();
        List<Integer> bst2 = new ArrayList<>();
        inorder(root1, bst1);
        inorder(root2, bst2);
        List<Integer> sol = new ArrayList<>();
        int i = 0, j = 0;
        while (i < bst1.size() || j < bst2.size()) {
            if (i < bst1.size() && j < bst2.size()) {
                if (bst1.get(i) < bst2.get(j)) {
                    sol.add(bst1.get(i));
                    i++;
                } else {
                    sol.add(bst2.get(j));
                    j++;
                }
            } else if (i < bst1.size()) {
                sol.add(bst1.get(i));
                i++;
            } else {
                sol.add(bst2.get(j));
                j++;
            }
        }
        return sol;
    }
}
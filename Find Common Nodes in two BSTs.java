import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution
{
    private static int search(Node root, int key) {
        if (root == null) {
            return -1;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.data == key) {
                return 1;
            } else if (cur.data > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return -1;
    }
    private static void inorder(Node root1, Node root2, ArrayList<Integer> sol) {
        if (root1 == null || root2 == null) {
            return;
        }
        inorder(root1, root2.left, sol);
        if (search(root1, root2.data) == 1) {
            sol.add(root2.data);
        }
        inorder(root1, root2.right, sol);
    }
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> sol = new ArrayList<>();
        inorder(root1, root2, sol);
        return sol;
    }
}
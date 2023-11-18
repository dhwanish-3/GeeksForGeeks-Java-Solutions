class Node{
    int data;
    Node left, right;
    Node(int d){
        data = d;
        left = right = null;
    }
}

class Solution
{
    Node head = null;
    Node prev = null;
    void solve(Node root) {
        if (root == null) {
            return;
        }
        solve(root.left);
        if (head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        solve(root.right);
    }
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        solve(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
}
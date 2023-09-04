class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}

class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
        {
            if (x.right != null) {
                Node cur = x.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            }
            Node successor = null;
            while (root != null) {
                if (x.data < root.data) {
                    successor = root;
                    root = root.left;
                } else if (x.data > root.data) {
                    root = root.right;
                } else {
                    break;
                }
            }
            return successor;
        }
}
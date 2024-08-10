class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    boolean flag = true;
    int rec(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int l = rec(root.left);
        int r = rec(root.right);
        if (l + r == root.data) {
            return l + r + root.data;
        } else {
            flag = false;
            return 0;
        }
    }
    boolean isSumTree(Node root) {
        rec(root);
        return flag;
    }
}
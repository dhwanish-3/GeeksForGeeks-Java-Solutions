class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution
{
    public static void inorder(Node root, ArrayList<Integer> leaf, ArrayList<Integer> in)
    {
        if (root == null) {
            return;
        }
        inorder(root.left, leaf, in);
        if (root.left == null && root.right == null) {
            leaf.add(root.data);
        }
        in.add(root.data);
        inorder(root.right, leaf, in);
    }
    public static boolean isDeadEnd(Node root)
    {
        ArrayList<Integer> leaf = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, leaf, in);
        for (int i : leaf) {
            if (i == 1 && in.contains(2)) {
                return true;
            }
            if (in.contains(i + 1) && in.contains(i - 1)) {
                return true;
            }
        }
        return false;
    }
}
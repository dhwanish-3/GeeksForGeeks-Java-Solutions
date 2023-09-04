class Tree
{
    private static void inorder(Node root, ArrayList<Integer> in) {
        if (root == null) {
            return;
        }
        inorder(root.left, in);
        in.add(root.data);
        inorder(root.right, in);
    }
    public static float findMedian(Node root)
    {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        int n = in.size();
        if (n % 2 == 1) {
            return in.get((n + 1) / 2 - 1);
        }
        return (in.get(n / 2 - 1) + in.get(n / 2)) / 2;
    }
}
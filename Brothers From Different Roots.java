import java.util.*;

class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}

class Solution
{
    private static void traverse(Node root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        traverse(root.left, set);
        set.add(root.data);
        traverse(root.right, set);
    }
    private static int count(Node root, Set<Integer> set, int x) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (set.contains(x - root.data)) {
            count++;
        }
        count += count(root.left, set, x);
        count += count(root.right, set, x);
        return count;
    }
	public static int countPairs(Node root1, Node root2, int x)
	{
        Set<Integer> set = new HashSet<>();
        traverse(root1, set);
        return count(root2, set, x);
	}
}
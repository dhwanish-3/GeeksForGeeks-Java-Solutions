import java.util.HashMap;

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

class Solution {
    String solve(Node root, HashMap<String, Integer> set) {
        if (root == null) {
            return "$";
        }
        if (root.right == null && root.left == null) {
            return String.valueOf(root.data);
        }
        String sol = "";
        sol += String.valueOf(root.data);
        sol += "/";
        sol += solve(root.left, set);
        sol += solve(root.right, set);
        set.put(sol, set.getOrDefault(sol, 0) + 1);
        return sol;
    }
    int dupSub(Node root) {
        HashMap<String, Integer> set = new HashMap<>();
        solve(root, set);
        for (HashMap.Entry<String, Integer> it : set.entrySet()) {
            if (it.getValue() > 1) {
                return 1;
            }
        }
        return 0;
    }
}
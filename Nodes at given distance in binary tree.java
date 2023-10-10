import java.util.*;

class Node  
{ 
    int data; 
    Node left, right;
}

class Solution
{
    private static void traverseChildren(Node root, int k, ArrayList<Integer> sol) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            sol.add(root.data);
            return;
        }
        traverseChildren(root.left, k - 1, sol);
        traverseChildren(root.right, k - 1, sol);
    }
    private static int kDistance(Node root, int target, int k, ArrayList<Integer> sol) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            traverseChildren(root, k, sol);
            return 0;
        }
        int left = kDistance(root.left, target, k, sol);
        if (left != -1) {
            if (left + 1 == k) {
                sol.add(root.data);
            } else {
                traverseChildren(root.right, k - left - 2, sol);
            }
            return 1 + left;
        }
        int right = kDistance(root.right, target, k, sol);
        if (right != -1) {
            if (right + 1 == k) {
                sol.add(root.data);
            } else {
                traverseChildren(root.left, k - right - 2, sol);
            }
            return 1 + right;
        }
        return -1;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> sol = new ArrayList<>();
        kDistance(root, target, k, sol);
        Collections.sort(sol);
        return sol;
    }
};
import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    private static void inorder(Node root, ArrayList<Integer> in) {
        if (root != null) {
            inorder(root.left, in);
            in.add(root.data);
            inorder(root.right, in);
        }
    }

    static void merge(Integer[] nodes, int low, int mid, int high, int[] sol) {
        int a = mid - low + 1;
        int b = high - mid;
        int[] left = new int[a];
        int[] right = new int[b];
        for (int i = 0; i < a; i++) {
            left[i] = nodes[low + i];
        }
        for (int i = 0; i < b; i++) {
            right[i] = nodes[mid + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < a && j < b) {
            if (left[i] <= right[j]) {
                nodes[k] = left[i];
                i++;
            } else {
                sol[0] += a - i;
                nodes[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < a) {
            nodes[k] = left[i];
            i++;
            k++;
        }
        while (j < b) {
            nodes[k] = right[j];
            j++;
            k++;
        }
    }

    static void mergeSort(Integer[] nodes, int low, int high, int[] sol) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nodes, low, mid, sol);
            mergeSort(nodes, mid + 1, high, sol);
            merge(nodes, low, mid, high, sol);
        }
    }

    public static int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        Integer[] arr = new Integer[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            arr[i] = nodes.get(i);
        }
        int[] sol = new int[1];
        mergeSort(arr, 0, n - 1, sol);
        return sol[0];
    }
}
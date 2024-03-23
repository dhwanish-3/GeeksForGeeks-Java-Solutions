import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Pair<T, F> {
    T first;
    F second;

    Pair(T first, F second) {
        this.first = first;
        this.second = second;
    }
}

class Tree {
    public static ArrayList<Integer> diagonalSum(Node root) {
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        Map<Integer, Integer> hash = new HashMap<>();
        while (!q.isEmpty()) {
            Node node = q.peek().first;
            int diag = q.peek().second;
            q.poll();
            hash.put(diag, hash.getOrDefault(diag, 0) + node.data);
            if (node.left != null) {
                q.add(new Pair(node.left, diag + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, diag));
            }
        }
        ArrayList<Integer> sol = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            sol.add(entry.getValue());
        }
        return sol;
    }
}
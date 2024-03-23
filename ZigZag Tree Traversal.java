import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    // Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> sol = new ArrayList<>();
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.peek();
                temp.add(node.data);
                q.poll();
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
            if ((level & 1) == 0) {
                for (int i = 0; i < temp.size(); i++) {
                    sol.add(temp.get(i));
                }
            } else {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    sol.add(temp.get(i));
                }
            }
        }
        return sol;
    }
}
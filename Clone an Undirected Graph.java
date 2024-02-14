import java.util.ArrayList;
import java.util.HashMap;

class Node {
    int val;
    ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    public void dfs(Node curNode, Node originalNode, HashMap<Integer, Node> map) {
        map.put(curNode.val, curNode);
        for (Node neighbour : originalNode.neighbors) {
            Node newNode;
            boolean notVisited = !map.containsKey(neighbour.val);
            if (notVisited) {
                newNode = new Node(neighbour.val);
            } else {
                newNode = map.get(neighbour.val);
            }
            curNode.neighbors.add(newNode);
            if (notVisited) {
                dfs(newNode, neighbour, map);
            }
        }
    }
    Node cloneGraph(Node node) {
        Node start = new Node(node.val);
        HashMap<Integer, Node> map = new HashMap<>();
        dfs(start, node, map);
        return start;
    }
}
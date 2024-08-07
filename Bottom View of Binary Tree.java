class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Pair {
    Node node;
    int dist;
    public Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution
{
    private void rec(Node root, List<List<Integer>> arr, int d) {
        
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> sol = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        // rec(root, arr, 0);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                map.put(p.dist, p.node.data);
                if (p.node.left != null) {
                    q.add(new Pair(p.node.left, p.dist - 1));
                }
                if (p.node.right != null) {
                    q.add(new Pair(p.node.right, p.dist + 1));
                }
            }
        }
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            sol.add(me.getValue());
        }
        return sol;
    }
}
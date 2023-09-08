import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> sol = new ArrayList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sol.add(cur);
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int next = adj.get(cur).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return sol;
    }
}
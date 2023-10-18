import java.util.*;

class Solution {
    boolean dfs(int node, List<List<Integer>> adj, int[] color) {
        if (color[node] != 0) {
            return color[node] == 1;
        }
        color[node] = 2;
        for (int i : adj.get(node)) {
            if (!dfs(i, adj, color)) {
                return false;
            }
        }
        color[node] = 1;
        return true;
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> sol = new ArrayList<>();
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, color)) {
                sol.add(i);
            }
        }
        return sol;
    }
}

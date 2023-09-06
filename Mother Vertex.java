import java.util.*;

class Solution
{
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!visited[adj.get(i).get(j)]) {
                dfs(adj, visited, adj.get(i).get(j));
            }
        }
    }
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int lastVisited = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                lastVisited = i;
            }
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        dfs(adj, visited, lastVisited);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return lastVisited;
    }
}
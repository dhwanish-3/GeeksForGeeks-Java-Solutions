import java.util.*;

class Solution
{
    private int find(int u, int[] parent){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u], parent);
    }
    private void union(int u, int v, int[] parent){
        int parentU = find(u, parent);
        int parentV = find(v, parent);
        if(parentU != parentV){
            parent[parentU] = parentV;
        }
    }
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] parent = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
        for(int i = 0; i < V; i++){
            for(int j : adj.get(i)){
                if (j < i) {
                    continue;
                }
                int parentI = find(i, parent);
                int parentJ = find(j, parent);
                if(parentI == parentJ){
                    return 1;
                }
                union(i, j, parent);
            }
        }
        return 0;
    }
}

import java.util.ArrayList;

class Solution {
    static boolean solve(ArrayList<ArrayList<Integer>> graph,int parent,int curr,boolean visited[]) {
        visited[curr] = true;
        for(int i: graph.get(curr)) {
            if(i == parent) {
                continue;
            }
            if(visited[i]) {
                return false;
            }
            if(!solve(graph,curr,i,visited)) {
                return false;
            }
        }
        return true;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(ArrayList<Integer> i : edges) {
            graph.get(i.get(0)).add(i.get(1));
            graph.get(i.get(1)).add(i.get(0));
        }
        
        boolean visited[] = new boolean[n];
        boolean ans = solve(graph,-1,0,visited);
        for(int i=0; i<n; i++) if(!visited[i]) {
            return false;
        }
        return ans;
    }
}
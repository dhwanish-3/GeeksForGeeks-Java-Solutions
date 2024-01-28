import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here

// creating a graph using adjacency list and keeping indegree of //each node


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<m;i++){
            int u = prerequisites.get(i).get(0);
            int v = prerequisites.get(i).get(1);
            adj.get(v).add(u);
            indegree[u]++;
        }
        

// Topological sort over graph


        Queue<Integer> q= new LinkedList<Integer>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int k = 0;
        int[] ans = new int[n];
        while(!q.isEmpty()){
            int node = q.remove();
            ans[k++] = node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(k != n) return new int[0];
        return ans;
    }
}
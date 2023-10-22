import java.util.*;

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        int[] level = new int[V];
        Arrays.fill(level, -1);
        level[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : adj.get(node)) {
                if (level[i] == -1) {
                    level[i] = level[node] + 1;
                    q.add(i);
                }
            }
        }
        return level[X];
    }
}
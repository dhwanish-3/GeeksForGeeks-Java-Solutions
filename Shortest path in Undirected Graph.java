class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[n];
        int[] sol = new int[n];
        for (int i = 0; i < n; i++) {
            sol[i] = -1;
        }
        int dist = 0;
        q.add(src);
        seen[src] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                sol[node] = dist;
                for (int j = 0; j < adj.get(node).size(); j++) {
                    if (!seen[adj.get(node).get(j)]) {
                        q.add(adj.get(node).get(j));
                        seen[adj.get(node).get(j)] = true;
                    }
                }
            }
            dist++;
        }
        return sol;
    }
}
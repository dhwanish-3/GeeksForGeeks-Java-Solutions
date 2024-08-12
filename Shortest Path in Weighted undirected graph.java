class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;
            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0], w = neighbour[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = w + dist[u];
                    parent[v] = u;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) return Arrays.asList(-1);
        List<Integer> path = new ArrayList<>();
        for (int at = n; at != 0; at = parent[at]) {
            path.add(at);
        }
        path.add(dist[n]);
        Collections.reverse(path);
        return path;
    }
}
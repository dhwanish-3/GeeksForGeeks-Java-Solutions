import java.util.Arrays;

class Pair     {
    int city;
    int distance;

    Pair(int city, int distance) {
        this.city = city;
        this.distance = distance;
    }

}

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int adj[][] = new int[n][n];
        for (int[] a : adj) {
            Arrays.fill(a, 100001);
        }
        for (int i = 0; i < n; i++) {
            adj[i][i] = 0;
        }
        for (int[] it: edges) {
            adj[it[0]][it[1]] = it[2];
            adj[it[1]][it[0]] = it[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        int sol = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                sol = i;
            }
        }
        return sol;
    }
}

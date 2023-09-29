import java.util.*;

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                grid[0][i] = -1;
                q.add(new Pair(0, i));
            }
            if (grid[n - 1][i] == 1) {
                grid[n - 1][i] = -1;
                q.add(new Pair(n - 1, i));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1) {
                grid[i][0] = -1;
                q.add(new Pair(i, 0));
            }
            if (grid[i][m - 1] == 1) {
                grid[i][m - 1] = -1;
                q.add(new Pair(i, m - 1));
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int i = cur.first;
            int j = cur.second;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                    grid[x][y] = -1;
                    q.add(new Pair(x, y));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
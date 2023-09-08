import java.util.*;

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O') {
                a[0][i] = 'D';
                q.add(Arrays.asList(0, i));
            }
            if (a[n - 1][i] == 'O') {
                a[n - 1][i] = 'D';
                q.add(Arrays.asList(n - 1, i));
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O') {
                a[i][0] = 'D';
                q.add(Arrays.asList(i, 0));
            }
            if (a[i][m - 1] == 'O') {
                a[i][m - 1] = 'D';
                q.add(Arrays.asList(i, m - 1));
            }
        }
        List<Integer> dirs = Arrays.asList(0, 1, 0, -1, 0);
        while (!q.isEmpty()) {
            List<Integer> cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.get(0) + dirs.get(i);
                int y = cur.get(1) + dirs.get(i + 1);
                if (x < 0 || x >= n || y < 0 || y >= m || a[x][y] != 'O') {
                    continue;
                }
                a[x][y] = 'D';
                q.add(Arrays.asList(x, y));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'D') {
                    a[i][j] = 'O';
                } else if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}
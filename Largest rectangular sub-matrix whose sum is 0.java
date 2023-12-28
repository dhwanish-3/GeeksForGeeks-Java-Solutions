import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] rowPrefix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + a[i - 1][j - 1];
            }
        }
        int best = 0;
        int sx, sy, ex, ey;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 0);
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += rowPrefix[k][j] - rowPrefix[k][i - 1];
                    if (map.containsKey(sum)) {
                        int area = (j - i + 1) * (k - map.get(sum));
                        if (area > best) {
                            best = area;
                            sx = map.get(sum) + 1;
                            sy = i;
                            ex = k;
                            ey = j;
                        }
                    } else {
                        map.put(sum, k);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        if (best == 0) {
            return sol;
        }
        for (int i = sx; i <= ex; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = sy; j <= ey; j++) {
                row.add(a[i - 1][j - 1]);
            }
            sol.add(row);
        }
        return sol;
    }
}
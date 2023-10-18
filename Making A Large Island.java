import java.util.*;

class Solution{
    int[] dirs = {-1, 0, 1, 0, -1};
    private int dfs(int[][] grid, int i, int j, int color) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = color;
        int count = 1;
        for(int k = 0; k < 4; k++) {
            count += dfs(grid, i + dirs[k], j + dirs[k + 1], color);
        }
        return count;
    }
    public int largestIsland(int N,int[][] grid) 
    {
        int max = 0;
        int color = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    int count = dfs(grid, i, j, color);
                    map.put(color++, count);
                    max = Math.max(max, count);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for(int k = 0; k < 4; k++) {
                        int x = i + dirs[k];
                        int y = j + dirs[k + 1];
                        if(x >= 0 && x < N && y >= 0 && y < N && grid[x][y] > 1) {
                            set.add(grid[x][y]);
                        }
                    }
                    int count = 1;
                    for(int c : set) {
                        count += map.get(c);
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int maxConnection(int[][] grid) {
        int n = grid.length;
        int[][] component = new int[n][n];
        List<Integer> componentSize = new ArrayList<>();
        componentSize.add(0); // Initialize with zero to make componentSize 1-based
        int compIndex = 1;

        // Find all components of 1's using DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && component[i][j] == 0) {
                    int size = dfs(grid, component, i, j, compIndex);
                    componentSize.add(size);
                    compIndex++;
                }
            }
        }

        int maxCon = 0;

        // Check the maximum connection without changing any 0
        for (int size : componentSize) {
            maxCon = Math.max(maxCon, size);
        }

        // Evaluate each 0 in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighboringComponents = new HashSet<>();
                    int possibleSize = 1; // Changing this 0 to 1

                    // Check all 4 directions
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && component[ni][nj] != 0) {
                            neighboringComponents.add(component[ni][nj]);
                        }
                    }

                    for (int comp : neighboringComponents) {
                        possibleSize += componentSize.get(comp);
                    }

                    maxCon = Math.max(maxCon, possibleSize);
                }
            }
        }

        return maxCon;
    }

    private int dfs(int[][] grid, int[][] component, int x, int y, int compIndex) {
        int n = grid.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        component[x][y] = compIndex;
        int size = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int i = cell[0];
            int j = cell[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1 && component[ni][nj] == 0) {
                    stack.push(new int[] {ni, nj});
                    component[ni][nj] = compIndex;
                }
            }
        }

        return size;
    }
}
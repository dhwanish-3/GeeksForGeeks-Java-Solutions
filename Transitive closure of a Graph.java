import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j || graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(graph[i][j]);
            }
            sol.add(temp);
        }
        return sol;
    }
}
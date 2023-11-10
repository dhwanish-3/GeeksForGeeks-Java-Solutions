import java.util.*;

class Solution{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        List<Integer> sol = new ArrayList<>();
        for (int c = 0; c < q; c++) {
            int hop = queries[c][0];
            int row = queries[c][1];
            int col = queries[c][2];
            int sum = 0;
            for (int i = -hop; i <= hop; i++) {
                for (int j = -hop; j <= hop; j++) {
                    boolean validRow = (row + i >= 0) && (row + i < n);
                    boolean validCol = (col + j >= 0) && (col + j < m);
                    if (validRow && validCol && (Math.abs(i) == hop || Math.abs(j) == hop)) {
                        sum += mat[row + i][col + j];
                    }
                }
            }
            sol.add(sum);
        }
        return sol;
    }
}
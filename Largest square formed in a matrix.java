class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int sol = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] > 0) {
                    mat[i][j] = 1 + Math.min(mat[i - 1][j - 1], Math.min(mat[i - 1][j], mat[i][j - 1]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sol = Math.max(sol, mat[i][j]);
            }
        }
        return sol;
    }
}
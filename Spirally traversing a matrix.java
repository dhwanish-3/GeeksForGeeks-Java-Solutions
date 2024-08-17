class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int n = mat.length, m = mat[0].length;
        int lr = 0, rl = n - 1;
        int td = m - 1, dt = 0;
        ArrayList<Integer> sol = new ArrayList<>();
        while (sol.size() < n * m) {
            for (int i = dt; i <= td && sol.size() < n * m; i++) {
                sol.add(mat[lr][i]);
            }
            lr++;
            for (int i = lr; i <= rl && sol.size() < n * m; i++) {
                sol.add(mat[i][td]);
            }
            td--;
            for (int i = td; i >= dt && sol.size() < n * m; i--) {
                sol.add(mat[rl][i]);
            }
            rl--;
            for (int i = rl; i >= lr && sol.size() < n * m; i--) {
                sol.add(mat[i][dt]);
            }
            dt++;
        }
        return sol;
    }
}
// Approach 1: Recursion + Memoization

class Solution{
    static int recursion(int n, int w, int val[], int wt[], int i, int[][] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i][w] != 0) {
            return dp[i][w];
        }
        if (wt[i] > w) {
            return dp[i][w] = recursion(n, w, val, wt, i + 1, dp);
        }
        return dp[i][w] = Math.max(val[i] + recursion(n, w - wt[i], val, wt, i, dp), recursion(n, w, val, wt, i + 1, dp));
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W + 1];
        return recursion(N, W, val, wt, 0, dp);
    }
}

// Approach 2: Tabulation
class SolutionDP{
    static int knapSack(int n, int w, int val[], int wt[]) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }
}
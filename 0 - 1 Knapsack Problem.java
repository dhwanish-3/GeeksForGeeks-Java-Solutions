class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int leave = dp[i - 1][j];
                int take = 0;
                if (j >= wt[i - 1]) take = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                dp[i][j] = Math.max(leave, take);
            }
        }
        return dp[n][W];
    }
}
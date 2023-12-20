class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = M[i][0];
        }
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int max = dp[i][j - 1];
                if (i > 0) {
                    max = Math.max(max, dp[i - 1][j - 1]);
                }
                if (i < n - 1) {
                    max = Math.max(max, dp[i + 1][j - 1]);
                }
                dp[i][j] = max + M[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][m - 1]);
        }
        return max;
    }
}
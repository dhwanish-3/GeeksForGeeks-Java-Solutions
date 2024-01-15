class Solution {
    private int rec(int i, int j, int[] cost) {
        if (i < 0) {
            return 0;
        }
        if (j <= 0) {
            return 0;
        }
        int chose = 1 + rec(i - 1, j - cost[i], cost);
        int lose = rec(i - 1, j, cost);
        return Math.max(chose, lose);
    }
    public int max_courses(int n, int total, int[] cost) {
        int[][] dp = new int[n + 1][total + 1];
        for (int i = 1; i <=  n; i++) {
            for (int j = (int)Math.floor(cost[i - 1] * 0.1); j <= total; j++) {
                if (j >= Math.floor(cost[i - 1] * 0.1)) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - (int)Math.floor(cost[i - 1] * 0.1)], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][total];
    }
}
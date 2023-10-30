class Solution{
    static int LCS(String s, String t, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
    static int minimumNumberOfDeletions(String S) {
        StringBuilder sb = new StringBuilder(S);
        String T = sb.reverse().toString();
        int n = S.length();
        return n - LCS(S, T, n);
    }
}
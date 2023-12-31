class Solution{
    static boolean match(String wild, String pattern)
    {
        int n = wild.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (wild.charAt(i) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (wild.charAt(i) == '*') {
                    dp[i][j] = dp[i + 1][j + 1] || dp[i][j + 1];
                } else {
                    if (wild.charAt(i) != pattern.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
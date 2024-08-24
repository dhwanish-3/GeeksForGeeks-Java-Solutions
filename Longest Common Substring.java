class Solution {
    private int rec(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int len = 0;
        while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
            len++;
        }
        return dp[i][j] = Math.max(len, Math.max(rec(s1, s2, i - len, j + 1 - len, dp), rec(s1, s2, i + 1 -len, j - len, dp)));
    }
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        // for (int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return rec(s1, s2, 0, 0, dp);
        int sol = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                sol = Math.max(sol, dp[i][j]);
            }
        }
        return sol;
    }
}
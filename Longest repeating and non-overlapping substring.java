class Solution {
    static String longestSubstring(String s, int n) {
        int dp[][] = new int[n + 1][n + 1];
        int max = 0;
        int index = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (max < Math.min(j -i, dp[i][j])) {
                        index = j;
                        max = Math.min(j - i, dp[i][j]);
                    }
                }
            }
        }
        if (index == -1) {
            return "-1";
        }
        return s.substring(index - max, index);
    }
};
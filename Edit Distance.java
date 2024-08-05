class Solution {
    private int rec(String s1, String s2, int i, int j) {
        if (i == s1.length() && j == s2.length()) return 0;
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if (s1.charAt(i) == s2.charAt(j)) return rec(s1, s2, i + 1, j + 1);
        else return 1 + Math.min(rec(s1, s2, i + 1, j), Math.min(rec(s1, s2, i, j + 1), rec(s1, s2, i + 1, j + 1)));
    }
    public int editDistance(String str1, String str2) {
        // Code here
        // return rec(str1, str2, 0, 0);
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][n2] = n1 - i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[n1][j] = n2 - j;
        }
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        return dp[0][0];
    }
}
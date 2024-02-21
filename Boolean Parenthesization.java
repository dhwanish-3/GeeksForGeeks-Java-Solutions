class Solution {
    static int mod = 1003;

    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static pair solve(int l, int r, String s, pair dp[][]) {
        if (l == r) {
            if (s.charAt(l) == 'T')
                return new pair(1, 0);
            else
                return new pair(0, 1);
        }
        if (dp[l][r] != null)
            return dp[l][r];
        int first = 0;
        int second = 0;
        for (int i = l + 1; i < r; i++) {
            if (s.charAt(i) == 'T' || s.charAt(i) == 'F')
                continue;

            pair left = solve(l, i - 1, s, dp);
            pair right = solve(i + 1, r, s, dp);

            if (s.charAt(i) == '|') {
                first = (first + (left.first * right.first) + (left.first * right.second) + (left.second * right.first)) % mod;
                second = (second + (left.second * right.second)) % mod;
            } else if (s.charAt(i) == '&') {
                first = (first + (left.first * right.first)) % mod;
                second = (second + (left.second * right.second) + (left.first * right.second) + (left.second * right.first)) % mod;
            } else if (s.charAt(i) == '^') {
                first = (first + (left.first * right.second) + (left.second * right.first)) % mod;
                second = (second + (left.second * right.second) + (left.first * right.first)) % mod;
            }

        }
        return dp[l][r] = new pair(first, second);
    }

    static int countWays(int n, String s) {
        pair dp[][] = new pair[n][n];
        // for(row[]:dp)Arrays.fill(row,-1);
        return solve(0, n - 1, s, dp).first;
    }
}
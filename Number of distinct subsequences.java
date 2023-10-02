class Solution {
    int distinctSubsequences(String S) {
        int mod = 1000000007;
        int n = S.length();
        int[] dp = new int[n + 1];
        int[] lastOccurence = new int[26];
        for (int i = 0; i < 26; i++) {
            lastOccurence[i] = -1;
        }
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;
            if (lastOccurence[S.charAt(i - 1) - 'a'] != -1) {
                dp[i] -= dp[lastOccurence[S.charAt(i - 1) - 'a']];
            }
            dp[i] %= mod;
            lastOccurence[S.charAt(i - 1) - 'a'] = i - 1;
        }
        return (dp[n] + mod) % mod;
    }
}
class Solution {
    // Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s) {
        int mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n];
        dp[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            dp[i] = ((dp[i - 1] * 10) % mod + (long) ((s.charAt(i) - '0') * (i + 1)) % mod) % mod;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + dp[i]) % mod;
        }
        return sum;
    }
}
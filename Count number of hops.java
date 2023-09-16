class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long[] dp = new long[n + 3];
        int mod = 1000000007;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }
        return dp[n] % mod;
    }
}
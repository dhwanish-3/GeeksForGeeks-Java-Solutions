class Solution
{
    private int rec(int n, int x, int y, int z, int[] dp) {
        if (n < 0) return Integer.MIN_VALUE;
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int X = 0, Y = 0, Z = 0;
        X = rec(n - x, x, y, z, dp);
        Y = rec(n - y, x, y, z, dp);
        Z = rec(n - z, x, y, z, dp);
        return dp[n] = 1 + Math.max(X, Math.max(Y, Z));
    }
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] dp = new int[n + 1];
       Arrays.fill(dp, -1);
       int sol = rec(n, x, y, z, dp);
       if (sol < 0) {
           return 0;
       }
       return sol;
    }
}
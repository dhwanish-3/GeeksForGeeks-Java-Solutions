// Approach 1 : DP
// Time Compelexity : O(n)
class DP {
    public int minOperation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp[n];
    }
}

// Approach 1 : Math
// Time Compelexity : O(logn)
class Solution
{
    public int minOperation(int n)
    {
        int ones = 0;
        int power = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                ones++;
            }
            power++;
            n /= 2;
        }
        return ones + power - 1;
    }
}
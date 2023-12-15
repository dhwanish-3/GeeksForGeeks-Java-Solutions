import java.util.*;

class Solution {
    // Recursion
    static int mod = 1000000007;
    private static long recursion(int i, int prev) {
        if (i == 0) {
            return 1;
        }
        long count = 0;
        if (prev == 1) {
            count = (count + (recursion(i - 1, 0) % mod)) % mod;
        } else {
            count = (count + recursion(i - 1, 0) % mod + recursion(i - 1, 1) % mod) % mod;
        }
        return count;
    }
    private static long recursive(int n) {
        return recursion(n - 1, 0) + recursion (n - 1, 1);
    }

    // Memoization
    private static long memoization(int i, int j, long[][] dp) {
        if (i == 0) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        long count = 0;
        if (j == 0) {
            count += memoization(i - 1, 1, dp);
        }
        count += memoization(i - 1, 0, dp);
        return dp[i][j] = count;
    }
    private static long memo(int n) {
        long dp[][] = new long[n][2];
        return memoization(n - 1, 0, dp) + memoization(n - 1, 1, dp);
    }

    // DP : Tabulation
    static long countStrings(int n) {
        int mod = 1000000007;
        long dp[][] = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][1] = dp[i - 1][0];
        }
        return (dp[n - 1][0] + dp[n - 1][1]) % mod;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(recursive(n));
        System.out.println(memo(n));
        System.out.println(countStrings(n));
    }
}
import java.util.*;

class Solution {
    static int mod = 1000000007;

    // Recursion
    public static long recursion(int i, int j, int n, int k) {
        if (i == n) {
            return 1;
        }
        long count = 0;
        if (j == 1) {
            count += ((k - 1) * recursion(i + 1, 0, n, k) % mod);
        } else {
            count += (recursion(i + 1, 1, n, k) + ((k - 1) * recursion(i + 1, 0, n, k) % mod));
        }
        return count;
    } 
    public static long recursive(int n, int k) {
        if (n == 1) {
            return k;
        }
        return k * recursion(1, 0, n, k);
    }

    // Memoization
    public static long memoization(int i, int j, int n, int k, long[][] dp) {
        if (i == n) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        long count = 0;
        if (j == 0) {
            count += (memoization(i + 1, 1, n, k, dp) % mod);
        }
        count += (((k - 1) * memoization(i + 1, 0, n, k, dp) % mod) % mod);
        return dp[i][j] = count;
    }
    public static long memo(int n, int k) {
        if (n == 1) {
            return k;
        }
        long[][] dp = new long[n][2];
        return dp[0][0] = (k * memoization(1, 0, n, k, dp) % mod);
    }

    // Tabulation
    public static long countWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        long[][] dp = new long[n + 1][2];
        dp[n][0] = 1;
        dp[n][1] = 1;
        for (int i = n - 1; i > 0; i--) {
            dp[i][0] = (dp[i + 1][1] + ((k - 1) * dp[i + 1][0])) % mod;
            dp[i][1] = ((k - 1) * dp[i + 1][0]) % mod;
        }
        return dp[0][0] = (k * dp[1][0]) % mod;
    }

    public static void main(String args[]) {
        int n = 2;
        int k = 4;
        System.out.println(recursive(n, k));
        System.out.println(memo(n, k));
        System.out.println(tab(n, k));
    }
}
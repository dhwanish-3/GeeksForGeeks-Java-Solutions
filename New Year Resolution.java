class Solution {
    public static boolean recursion(int i, int[] coins, int sum) {
        if (i == coins.length) {
            return false;
        }
        int newSum = sum + coins[i];
        if (newSum % 20 == 0 || newSum % 24 == 0 || newSum == 2024) {
            return true;
        }
        return recursion(i + 1, coins, sum + coins[i]) || recursion(i + 1, coins, sum);
    }
    public static boolean isPossible(int N, int[] coins) {
        return recursion(0, coins,0);
    }
}
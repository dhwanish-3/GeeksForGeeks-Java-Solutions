class Solution
{
    public int min_operations(int []nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int LIS = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] - nums[j] >= i - j) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    LIS = Math.max(LIS, dp[i]);
                }
            }
        }
        return n - LIS;
    }
}
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int mod = 1000000007;
        int dp[][] = new int[n + 1][sum + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(arr[i - 1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % mod;
                }
            }
        }
        return dp[n][sum];
	}
}
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{
	    int[] dp = new int[n];
	    dp[0] = arr[0];
	    int sol = arr[0];
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
	            if (arr[i] > arr[j]) {
	                dp[i] = Math.max(dp[i], dp[j]);
	            }
	        }
	        dp[i] += arr[i];
	        sol = Math.max(sol, dp[i]);
	    }
	    return sol;
	}  
}
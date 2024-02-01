class Solution
{
    static int solve(char str[], int i, int sum, int dp[][])
    {
        if(i == str.length) {
            return 1;
        }
        if(dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int sol = 0;
        int num = 0;
        for(int j = i; j < str.length; j++){
            num += str[j] - '0';
            if(num >= sum) {
                sol += solve(str, j + 1, num, dp);
            } 
        }
        return dp[i][sum] = sol;
    }
    public int TotalCount(String str)
    {
        int n = str.length();
        int dp[][] = new int[n][901];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 901; j++){
                dp[i][j] = -1;
            }
        }
        return solve(str.toCharArray(), 0, 0, dp);
    }
}
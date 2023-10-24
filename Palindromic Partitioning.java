class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];
        boolean[][] p = new boolean[n][n];
        for(int i = 0; i < n; i++){
            p[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                p[i][i + 1] = true;
            }
        }
        for(int gap = 2; gap < n; gap++){
            for(int i = 0; i < n - gap; i++){
                int j = i + gap;
                if(str.charAt(i) == str.charAt(j) && p[i + 1][j - 1]){
                    p[i][j] = true;
                }
            }
        }
        for(int gap = 1; gap < n; gap++){
            for(int i = 0; i < n - gap; i++){
                int j = i + gap;
                if(p[i][j]){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 1);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
class Solution {
    int[] Series(int n) {
        int mod = 1000000007;
        int[] sol = new int[n + 1];
        sol[0] = 0;
        sol[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            sol[i] = (sol[i - 1] + sol[i - 2]) % mod;
        }
        return sol;
    }
}
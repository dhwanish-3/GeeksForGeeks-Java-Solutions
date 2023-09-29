class Solution {
    public static int findCatalan(int n) {
        int mod = (int)1e9 + 7;
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + (catalan[j] * catalan[i - j - 1]) % mod) % mod;
            }
        }
        return (int)(catalan[n] % mod);
    }
}
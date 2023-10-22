class Solution{
    int mod = 1000000007;
    long modInverse(int a, int b) {
        int x = 1;
        int y = 0;
        while (a > 1) {
            int q = a / b;
            int temp = b;
            b = a % b;
            a = temp;
            temp = y;
            y = x - q * y;
            x = temp;
        }
        return x < 0 ? x + mod : x;
    }
    long numberOfPaths(int M, int N) {
        int n = M + N - 2;
        int r = M - 1 < N - 1 ? M - 1 : N - 1;
        long sol = 1;
        for (int i = 1; i <= r; i++) {
            sol = (sol * (n - r + i) % mod * modInverse(i, mod)) % mod;
        }
        return sol;
    }
}
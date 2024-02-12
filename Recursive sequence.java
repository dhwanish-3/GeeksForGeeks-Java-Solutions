class Solution{
    static int mod = 1000000007;
    static long sequence(int n) {
        long total = 0;
        long start = 1;
        for (int i = 0; i < n; i++) {
            long sum = 1;
            long j = start;
            for (; j <= start + i; j++) {
                sum = (sum * j) % mod;
            }
            total = (total + sum) % mod;
            start = j;
        }
        return total % mod;
    }
}
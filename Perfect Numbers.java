class Solution {
    static int isPerfectNumber(long N) {
        if (N % 2 == 1) {
            return 0;
        }
        long sum = 1;
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                sum += i;
                if (i * i != N) {
                    sum += N / i;
                }
            }
        }
        if (sum == N && N != 1) {
            return 1;
        }
        return 0;
    }
};
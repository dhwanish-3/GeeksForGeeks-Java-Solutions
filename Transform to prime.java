class Solution {
    boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int minNumber(int arr[], int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if (sum == 1) {
            return 1;
        }
        if (isPrime(sum)) {
            return 0;
        }
        int i = 0;
        while (!isPrime(sum + i)) {
            i++;
        }
        return i;
    }
}
class Solution {
    static boolean isPrime(int n) {
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

    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp;
            n /= 10;
        }
        return sum;
    }

    static int sumOfPrimeFactor(int n) {
        int sum = 0;
        int f = 1;
        while (n > 1) {
            f++;
            if (!isPrime(f)) {
                continue;
            }
            while (n % f == 0) {
                sum += sumOfDigits(f);
                n /= f;
            }
        }
        return sum;
    }

    static int smithNum(int n) {
        if (isPrime(n)) {
            return 0;
        }
        int sumOfDigits = sumOfDigits(n);
        int sumOfPrimeFactor = sumOfPrimeFactor(n);
        if (sumOfDigits == sumOfPrimeFactor) {
            return 1;
        }
        return 0;
    }
};
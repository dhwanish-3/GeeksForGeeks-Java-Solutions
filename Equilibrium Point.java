class Solution {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1;
        }
        long[] sum = new long[n];
        int sol = -1;
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 1; i < n - 1; i++) {
            if (sum[i - 1] == sum[n - 1] - sum[i]) {
                sol = i + 1;
                break;
            }
        }
        return sol;
    }
}

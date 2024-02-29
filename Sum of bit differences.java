class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long sol = 0;
        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) == 0) {
                    count++;
                }
            }
            sol += (2 * count * (n - count));
        }
        return sol;
    }
}
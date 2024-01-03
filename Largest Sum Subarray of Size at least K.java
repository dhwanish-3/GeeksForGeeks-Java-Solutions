class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long[] prefixSum = new long[(int)n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }
        long[] minPrefixSum = new long[(int)n + 1];
        minPrefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            minPrefixSum[i] = Math.min(minPrefixSum[i - 1], prefixSum[i]);
        }
        long maxSum = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i < k) {
                continue;
            }
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefixSum[i - (int)k]);
        }
        return maxSum;
    }
}
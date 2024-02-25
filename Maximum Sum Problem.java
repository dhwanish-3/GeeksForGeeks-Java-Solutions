class Solution {
    int helper(int n, int i) {
        if (n < 12) {
            return n;
        }
        int maxSum = 0;
        while (i < 5 && n / i > 0) {
            maxSum += Math.max(n / i, helper(n / i, 2));
            i++;
        }
        return maxSum;
    }

    public int maxSum(int n) {
        return helper(n, 2);
    }
}

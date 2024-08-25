class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long[] sol = new long[n];
        long total = 1, zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zero++;
            else total *= nums[i];
        }
        if (zero > 1) return sol;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && zero == 0) sol[i] = total / nums[i];
            else if (nums[i] == 0 && zero == 1) sol[i] = total;
        }
        return sol;
    }
}

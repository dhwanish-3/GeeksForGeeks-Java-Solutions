class Solution {
    static int threeSumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        int sol = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                // System.out.println(sum);
                if (target == sum) {
                    return sum;
                } else if (Math.abs(target - sol) > Math.abs(target - sum)) {
                    sol = sum;
                } else if (Math.abs(target - sol) == Math.abs(target - sum)) {
                    sol = Math.max(sol, sum);
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        
        return sol;
    }
}

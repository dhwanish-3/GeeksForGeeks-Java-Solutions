class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int sol = arr[n - 1] - arr[0];
        for (int i = 0; i < n; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = i > 0 ? Math.max(arr[n - 1] - k, arr[i - 1] + k) : arr[n - 1] - k;
            if (min < 0) {
                continue;
            }
            sol = Math.min(sol, max - min);
        }
        return sol;
    }
}

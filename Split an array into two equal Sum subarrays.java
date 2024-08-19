class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == left[n - 1] - left[i]) {
                return true;
            }
        }
        return false;
    }
}
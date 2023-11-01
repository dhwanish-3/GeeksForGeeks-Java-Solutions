class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (arr[r] == 0) {
                    arr[r] = arr[i];
                    arr[i] = 0;
                }
                r++;
            }
        }
    }
}
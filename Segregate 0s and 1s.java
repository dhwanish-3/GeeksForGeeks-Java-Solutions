class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0) {
                arr[i++] = 0;
            }
        }
        while (i < n) {
            arr[i++] = 1;
        }
    }
}
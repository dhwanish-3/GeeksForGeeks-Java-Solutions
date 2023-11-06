class Solution {
    int transitionPoint(int arr[], int n) {
        int l = 0;
        int r = n - 1;
        int i = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == 1) {
                i = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return i;
    }
}
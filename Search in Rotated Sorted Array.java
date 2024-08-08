class Solution {
    int binary(int[] arr, int l, int r, int k) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    int search(int[] arr, int key) {
        // Complete this function
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[n - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int left = binary(arr, 0, l - 1, key);
        if (left != -1) {
            return left;
        } else {
            return binary(arr, l, n - 1, key);
        }
    }
}
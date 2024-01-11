class Solution {
    static boolean isPossible(int[] arr, int N, int K, int mid) {
        int cur = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                return false;
            }
            if (cur + arr[i] > mid) {
                count++;
                cur = arr[i];
                if (count > K) {
                    return false;
                }
            } else {
                cur += arr[i];
            }
        }
        return true;
    }
    static int splitArray(int[] arr , int N, int K) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};
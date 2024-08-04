class Solution {
    void mergeSort(int[] arr, int[] indices, int[] sol, int l, int r) {
        if (r - l <= 1) return;
        int mid = (l + r) / 2;
        mergeSort(arr, indices, sol, l, mid);
        mergeSort(arr, indices, sol, mid, r);
        
        int[] temp = new int[r - l];
        int left = l, right = mid, rightCount = 0, i = 0;
        
        while (left < mid && right < r) {
            if (arr[indices[right]] < arr[indices[left]]) {
                temp[i++] = indices[right];
                rightCount++;
                right++;
            } else {
                temp[i++] = indices[left];
                sol[indices[left]] += rightCount;
                left++;
            }
        }
        
        while (left < mid) {
            temp[i++] = indices[left];
            sol[indices[left]] += rightCount;
            left++;
        }
        while (right < r) {
            temp[i++] = indices[right];
            right++;
        }
        
        System.arraycopy(temp, 0, indices, l, r - l);
    }
    int[] constructLowerArray(int[] arr) {
        // code here
        int n = arr.length;
        int[] sol = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(arr, indices, sol, 0, n);
        return sol;
    }
}
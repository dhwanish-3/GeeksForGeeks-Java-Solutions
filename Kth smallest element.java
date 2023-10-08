import java.util.Collections;
import java.util.PriorityQueue;

//  Approach 1 : Using Max Heap of size k
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = l; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i <= r; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    } 
}

// Approach 2 : Quick Select
class QuicSelect {
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
    }
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, r, i + 1);
        return i + 1;
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        int p = partition(arr, l, r);
        if (p == k - 1) {
            return arr[p];
        }
        if (p > k - 1) {
            return kthSmallest(arr, l, p - 1, k);
        } else {
            return kthSmallest(arr, p + 1, r, k);
        }
    } 
}
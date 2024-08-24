class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (arr[i] <= pq.peek()) {
                pq.add(arr[i]);
                pq.poll();
            }
        }
        return pq.peek();
    }
}

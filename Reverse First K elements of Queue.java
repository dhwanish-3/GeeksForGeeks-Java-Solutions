import java.util.Queue;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (q == null || q.isEmpty()) {
            return q;
        }
        int size = q.size();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = q.poll();
        }
        for (int i = k - 1; i >= 0; i--) {
            q.add(arr[i]);
        }
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }
        return q;
    }
}

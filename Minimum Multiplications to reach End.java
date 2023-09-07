import java.util.*;

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        int[] dist = new int[100000];
        for (int i = 0; i < 100000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        int mod = 100000;
        int n = arr.length;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.first;
            int steps = p.second;
            for (int i = 0; i < n; i++) {
                int num = (arr[i] * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end) {
                        return steps + 1;
                    }
                    q.add(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }
}
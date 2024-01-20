import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(b) - map.get(a);
            } else {
                return a - b;
            }});
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            pq = new PriorityQueue<>((a, b) -> {
                if (map.get(a) != map.get(b)) {
                    return map.get(b) - map.get(a);
                } else {
                    return a - b;
                }});
            for (int key : map.keySet()) {
                pq.add(key);
            }
            int keyK = K;
            ArrayList<Integer> temp = new ArrayList<>();
            while (keyK-- > 0 && !pq.isEmpty()) {
                temp.add(pq.poll());
            }
            sol.add(temp);
        }
        return sol;
    }
}
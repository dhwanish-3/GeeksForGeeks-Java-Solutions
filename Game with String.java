import java.util.Collections;
import java.util.PriorityQueue;

class Solution{
    static int minValue(String s, int k){
        int n = s.length();
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            hash[(int)(s.charAt(i) - 'a')]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) {
                pq.add(hash[i]);
            }
        }
        while (k > 0) {
            int temp = pq.poll();
            temp--;
            pq.add(temp);
            k--;
        }
        int sol = 0;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            System.out.println(temp);
            sol += temp * temp;
        }
        return sol;
    }
}
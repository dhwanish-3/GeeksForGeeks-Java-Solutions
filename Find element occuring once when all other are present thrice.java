import java.util.HashMap;

class Solution {
    static int singleElement(int[] arr , int N) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hash.put(arr[i], 1 + hash.getOrDefault(arr[i], 0));
        }
        for (Integer it : hash.keySet()) {
            if (hash.get(it) == 1) {
                return it;
            } 
        }
        return -1;
    }
}
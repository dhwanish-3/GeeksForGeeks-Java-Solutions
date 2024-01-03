import java.util.HashMap;

class Solution {
    public boolean canPair(int[] nums, int k) {
        int n = nums.length;
        if (n % 2 != 0) {
            return false;
        }
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = nums[i] % k;
            int need = (k - cur) % k;
            if (hash.get(need) == null || hash.get(need) == 0) {
                hash.put(cur, 1);
            } else {
                hash.put(need, hash.get(need) - 1);
            }
        }
        for (Integer key : hash.keySet()) {
            if (hash.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}
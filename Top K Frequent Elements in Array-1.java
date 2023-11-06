class Solution {
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b - a;
            }
            return map.get(b) - map.get(a);
        });
        for (int key : map.keySet()) {
            pq.add(key);
        }
        int[] sol = new int[k];
        int i = 0;
        while (i < k) {
            sol[i++] = pq.poll();
        }
        return sol;
    }
}
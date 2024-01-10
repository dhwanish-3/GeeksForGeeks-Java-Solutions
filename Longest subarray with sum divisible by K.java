import java.util.HashMap;

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        map.put(0, -1);
        int reminderSum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            reminderSum = sum % k;
            if (reminderSum < 0) {
                reminderSum += k;
            }
            if (map.containsKey(reminderSum)) {
                maxLen = Math.max(maxLen, i - map.get(reminderSum));
            } else {
                map.put(reminderSum, i);
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
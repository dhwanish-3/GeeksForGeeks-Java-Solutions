import java.util.HashMap;

class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(arr[i], 1 + hash.getOrDefault(arr[i], 0));
        }
        int count = 0;
        for (HashMap.Entry<Integer, Integer> it : hash.entrySet()) {
            if (it.getValue() > (n / k)) {
                count++;
            }
        }
        return count;
    }
}

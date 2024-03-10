import java.util.HashMap;

class Solution {
    // Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n) {
        HashMap<String, Integer> hash = new HashMap<>();
        String[] sol = new String[2];
        sol[1] = "0";
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], 1 + hash.getOrDefault(arr[i], 0));
        }
        for (String key : hash.keySet()) {
            int value = hash.get(key);
            if (value > Integer.parseInt(sol[1]) || (value == Integer.parseInt(sol[1]) && sol[0].compareTo(key) > 0)) {
                sol[0] = key;
                sol[1] = String.valueOf(value);
            }
        }
        return sol;
    }
}
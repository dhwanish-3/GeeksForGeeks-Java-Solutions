import java.util.*;

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        int squares[] = new int[n];
        HashSet<Integer> set = new HashSet<>(); 
        for (i = 0; i < n; i++) {
            squares[i] = arr[i] * arr[i];
            set.add(squares[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (set.contains(squares[i] + squares[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
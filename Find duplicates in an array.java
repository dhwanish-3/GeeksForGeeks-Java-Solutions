import java.util.ArrayList;;

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1) {
                sol.add(i);
            }
        }
        if (sol.isEmpty()) {
            sol.add(-1);
        }
        return sol;
    }
}

import java.util.ArrayList;

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        int[] right = new int[n];
        ArrayList<Integer> sol = new ArrayList<>();
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= right[i]) {
                sol.add(arr[i]);
            }
        }
        return sol;
    }
}

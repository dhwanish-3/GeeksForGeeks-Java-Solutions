import java.util.ArrayList;

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        int minDiff = Math.abs(arr[i] + brr[j] - x);
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(0, arr[i]);
        sol.add(1, brr[j]);
        while (i < n && j >= 0) {
            int sum = arr[i] + brr[j];
            int diff = Math.abs(sum - x);
            if (diff < minDiff) {
                minDiff = diff;
                sol.add(0, arr[i]);
                sol.add(1, brr[j]);
            }
            if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        return sol;
    }
    public static void main(String args[]) {
        int arr[] = {1, 1, 3, 4, 5, 6 ,7 ,8 ,9};
        int brr[] = {1, 1, 2, 4, 4, 5, 6, 6, 9};
        int x = 10;
        System.out.println(printClosest(arr, brr, arr.length, brr.length, x));
    }
}
import java.util.*;
class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> sol = new ArrayList<>();
        int sum = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            sum += arr[r];
            if (sum == s) {
                sol.add(l + 1);
                sol.add(r + 1);
                return sol;
            }
            while (sum > s && l < r) {
                sum -= arr[l];
                l++;
            }
            if (sum == s) {
                sol.add(l + 1);
                sol.add(r + 1);
                return sol;
            }
            r++;
        }
        System.out.println(-1);
        sol.add(-1);
        return sol;
    }
}
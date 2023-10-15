import java.util.*;

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        int i = 0;
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>(0);
        while (i < n) {
            while (i + 1 < n && A[i] >= A[i + 1]) {
                i++;
            }
            int start = i;
            i++;
            while (i + 1 < n && A[i] <= A[i + 1]) {
                i++;
            }
            if (i >= n) {
                break;
            }
            int end = i;
            sol.add(new ArrayList<>(Arrays.asList(start, end)));
            i++;
        }
        return sol;
    }
}

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if (sum == k) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[l]);
                        temp.add(arr[r]);
                        if (!sol.contains(temp)) {
                            sol.add(temp);
                        }
                        l++;
                        r--;
                    } else if (sum > k) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return sol;
    }
}
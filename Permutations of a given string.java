import java.util.*;

class Solution {
    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    void helper(char[] arr, int index, List<String> sol) {
        if (index == arr.length) {
            sol.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            helper(arr, index + 1, sol);
            swap(arr, index, i);
        }
    }
    void removeDuplicates(List<String> sol) {
        int i = 0;
        while (i < sol.size() - 1) {
            if (sol.get(i).equals(sol.get(i + 1))) {
                sol.remove(i);
            } else {
                i++;
            }
        }
    }
    public List<String> find_permutation(String S) {
        List<String> sol = new ArrayList<>();
        helper(S.toCharArray(), 0, sol);
        Collections.sort(sol);
        removeDuplicates(sol);
        return sol;
    }
}
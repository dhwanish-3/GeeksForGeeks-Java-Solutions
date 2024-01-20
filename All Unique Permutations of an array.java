import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        HashSet<ArrayList<Integer>> lis = new HashSet<>();
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        perm(arr, 0, n, lis, sol);
        
        Collections.sort(sol, (a, b)->{
            int s = a.size();
            for(int i = 0; i < s; i++){
                if(a.get(i) != b.get(i)) {
                    return Integer.compare(a.get(i), b.get(i));
                }
            }
            return Integer.compare(a.get(0), b.get(0));
            
        });
        return sol;
    }
    
    static void perm(ArrayList<Integer> arr, int i, int n,HashSet<ArrayList<Integer>> lis, ArrayList<ArrayList<Integer>> sol){
        if (i == n) {
           if (lis.contains(arr)) {
                return;
           }
           lis.add(new ArrayList<>(arr));
           sol.add(new ArrayList<>(arr));
        }
        for (int j = i; j < n; j++) {
            swap(arr, i, j);
            perm(arr, i + 1, n, lis, sol);
            swap(arr, i, j);
        }
    }
    
    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
};
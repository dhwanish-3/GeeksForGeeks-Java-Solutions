import java.util.*;

class Solution{
    public String findString(int n, int k){
        String sol = "";
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sol += "0";
        }
        set.add(sol);
        String temp;
        for (int i = k - 1; i >= 0; i--) {
            temp = sol.substring(sol.length() - n + 1);
            temp += Integer.toString(i);
            if (set.contains(temp)) {
                continue;
            } else {
                sol += Integer.toString(i);
                set.add(temp);
                i = k;
            }
        }
        return sol;
    }
}
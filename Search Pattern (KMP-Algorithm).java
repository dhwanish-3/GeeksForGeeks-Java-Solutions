import java.util.ArrayList;

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> sol = new ArrayList<>();
        int dif = txt.length() - pat.length();
        for (int i = 0; i <= dif; i++) {
            int j = 0;
            for (; j < pat.length() && pat.charAt(j) == txt.charAt(i + j); j++) {
                if (pat.charAt(j) != txt.charAt(i + j))
                    break;
            }
            if (j == pat.length()) {
                sol.add(i + 1);
            }
        }
        return sol;
    }
}
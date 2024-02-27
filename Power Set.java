import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution
{
    private void helper(String s, String str, List<String> sol, int i) {
        if (s.length() == i) {
            sol.add(str);
            return;
        }
        char ch = s.charAt(i);
        helper(s, str + ch, sol, i + 1);
        helper(s, str, sol, i + 1);
    }
    public List<String> AllPossibleStrings(String s)
    {
        List<String> sol = new ArrayList<>();
        helper(s, "", sol, 0);
        Collections.sort(sol);
        sol.remove("");
        return sol;
    }
}
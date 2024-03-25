import java.util.ArrayList;

class Solution {
    void recursion(int i, ArrayList<String> sol, StringBuilder sb, int moreOnes) {
        if (i == 0) {
            sol.add(sb.toString());
            return;
        }
        StringBuilder newSb1 = new StringBuilder(sb.toString());
        StringBuilder newSb0 = new StringBuilder(sb.toString());
        recursion(i - 1, sol, newSb1.append("1"), moreOnes + 1);
        if (moreOnes > 0) {
            recursion(i - 1, sol, newSb0.append("0"), moreOnes - 1);
        }
    }
    ArrayList<String> NBitBinary(int n) {
        ArrayList<String> sol = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursion(n, sol, sb, 0);
        return sol;
    }
}
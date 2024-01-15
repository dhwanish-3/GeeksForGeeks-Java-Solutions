import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        Set<String> set = new HashSet<>();
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(matrix[i][j]);
            }
            String s = row.toString();
            if (set.contains(s)) {
                sol.add(i);
            } else {
                set.add(s);
            }
        }
        return sol;
    }
}
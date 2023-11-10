import java.util.*;

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        ArrayList<Integer> sol = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    sol.add(matrix[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    sol.add(matrix[i][j]);
                }
            }
        }
        return sol;
    }
}
import java.util.*;

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sol.add(matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            sol.add(matrix[i][m - 1]);
        }
        for (int i = m - 2; i >= 0 && n > 1; i--) {
            sol.add(matrix[n - 1][i]);
        }
        for (int i = n - 2; i > 0 && m > 1; i--) {
            sol.add(matrix[i][0]);
        }
        return sol;
    }
}

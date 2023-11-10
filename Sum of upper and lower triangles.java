import java.util.*;

class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        ArrayList<Integer> sol = new ArrayList<>();
        int upperSum = 0;
        int lowerSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                upperSum += matrix[i][j];
            for (int j = 0; j <= i; j++)
                lowerSum += matrix[i][j];
        }
        sol.add(upperSum);
        sol.add(lowerSum);
        return sol;
    }
}
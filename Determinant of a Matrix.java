class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        if (n == 1) {
            return matrix[0][0];
        }
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int[][] temp = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (l == i) {
                        continue;
                    }
                    temp[j - 1][k++] = matrix[j][l];
                }
            }
            sol += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinantOfMatrix(temp, n - 1);
        }
        return sol;
    }
}
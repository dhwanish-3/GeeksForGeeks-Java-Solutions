class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            if (row[i]) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            if (col[i]) {
                for (int j = 0; j < r; j++) {
                    matrix[j][i] = 1;
                }
            }
        }
    }
}
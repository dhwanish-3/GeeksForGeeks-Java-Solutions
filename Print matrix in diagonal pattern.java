class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int count = n * n;
        int[] sol = new int[count];
        int temp = 2;
        int i = 0, j = 0;
        int k = 0;
        sol[k] = mat[i][j];
        k++;
        while(k < count) {
            if (j == n - 1) {
                i++;
            } else {
                j++;
            }
            while (i < n && j >= 0){
                sol[k] = mat[i][j];
                i++;
                j--;
                k++;
            }
            i--;
            j++;
            if (i == n - 1) {
                j++;
            } else {
                i++;
            }
            while (i >= 0 && j < n) {
                sol[k] = mat[i][j];
                i--;
                j++;
                k++;
            }
            i++;
            j--;
        }
        return sol;
    }
}
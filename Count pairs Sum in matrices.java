class Solution {
    int binarySearch(int mat[][], int n, int target) {
        int row = 0;
        int col = mat[row].length - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] == target) {
                return target;
            } else if (mat[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return -1;
    }
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (binarySearch(mat2, n, x - mat1[i][j]) != -1) {
                    count++;
                }
            }
        }
        return count;
    }
}
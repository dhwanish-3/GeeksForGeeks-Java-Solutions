class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int[] votes = new int[n];
        int[] knows = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    votes[j]++;
                    knows[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (knows[i] == 0 && votes[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
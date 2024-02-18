class Solution
{
    public int isPossible(int[][] paths)
    {
        int n = paths.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < paths[0].length; j++) {
                count += paths[i][j];
            }
            if ((count & 1) > 0) {
                return 0;
            }
        }
        return 1;
    }
}
class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int n = matrix.length;
        int[] result = new int[n * n];
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            int row = 0;
            int col = i;
            while(row < n && col >= 0)
            {
                result[index++] = matrix[row++][col--];
            }
        }
        for(int i = 1; i < n; i++)
        {
            int row = i;
            int col = n - 1;
            while(row < n && col >= 0)
            {
                result[index++] = matrix[row++][col--];
            }
        }
        return result;
    }
}
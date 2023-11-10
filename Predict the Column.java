class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        int max = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }
        return index;
    }
}
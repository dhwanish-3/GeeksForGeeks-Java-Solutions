class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (arr[i] < min || arr[i] > max) {
                return 0;
            }
            if (arr[i] < arr[i - 1]) {
                max = arr[i - 1];
            } else {
                min = arr[i - 1];
            }
        }
        return 1;
    }
}
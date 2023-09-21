class Solution
{
    //Function to find the maximum money the thief can get.
    public static int FindMaxSum(int arr[], int n)
    {
        int prev = 0;
        int prev2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = prev2;
            prev2 = Math.max(arr[i] + prev, prev2);
            prev = temp;
        }
        return prev2;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 5, 7, 4};
        System.out.println(FindMaxSum(arr, arr.length));
    }
}
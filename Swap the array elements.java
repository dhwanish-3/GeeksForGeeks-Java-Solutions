class Solution
{
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void swapElements(int[] arr, int n)
    {
        // Code here
        for (int i = 0; i < n - 2; i++) {
            swap(arr, i, i + 2);
        }
    }
}
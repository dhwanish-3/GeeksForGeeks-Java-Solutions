class Solution{
    private boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (checkKthBit(arr[j], i)) {
                    count++;
                }
            }
            sum += (long)(1 << i) * count * (n - count);
        }
        return sum;
    }
}
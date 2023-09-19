class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        long curSum = 0;
        long maxSum = Math.min(arr[0], 0);
        for (int i = 0; i < n; i++) {
            curSum += arr[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
    
}
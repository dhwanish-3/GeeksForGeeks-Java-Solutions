import java.util.*;

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += Arr.get(i);
        }
        maxSum = sum;
        for (int i = K; i < N; i++) {
            sum += Arr.get(i) - Arr.get(i - K);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
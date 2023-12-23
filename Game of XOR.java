class Solution {
    // xor of all the subarrays
    static int gameOfXor(int N , int[] A) {
        int sol = 0;
        if (N % 2 == 0) {
            return 0;
        }
        for (int i = 0; i < N; i += 2) {
            sol ^= A[i];
        }
        return sol;
    }
};
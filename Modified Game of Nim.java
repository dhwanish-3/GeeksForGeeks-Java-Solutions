class Solution{
    static int findWinner(int n, int A[]){
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= A[i];
        }
        if (xor == 0) {
            return 1;
        }
        return (n & 1) == 1 ? 2 : 1;
    }
}
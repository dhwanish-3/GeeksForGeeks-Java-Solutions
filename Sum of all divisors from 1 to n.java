class Solution{
    static long sumOfDivisors(int N){
        long sol = 0;
        for (int i = 1; i <= N; i++) {
            sol += (N / i) * i;
        }
        return sol;
    }
}
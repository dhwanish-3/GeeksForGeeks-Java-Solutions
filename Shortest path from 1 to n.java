class Solution{
    public int minStep(int n)
    {
        int sol = 0;
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n -= 1;
            }
            sol++;
        }
        return sol;
    }
}
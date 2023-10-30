class Solution
{
    public int is_bleak(int n)
    {
        int num = n;
        int bits = 0;
        while (num != 0) {
            bits++;
            num /= 2;
        }
        for (int i = n - bits; i < n; i++) {
            if (i + Integer.bitCount(i) == n) {
                return 0;
            }
        }
        return 1;
    }
}
class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        if (m == n) {
            return -1;
        }
        int i = 1;
        while (m != 0 || n != 0) {
            if (m % 2 != n % 2) {
                return i;
            }
            m /= 2;
            n /= 2;
            i++;
        }
        return i + 1;
    }
}
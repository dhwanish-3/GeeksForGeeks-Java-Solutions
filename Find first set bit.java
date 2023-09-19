class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        if (n == 0) {
            return 0;
        }
        int pos = 0;
        while ((n & (1 << pos)) == 0) {
            pos++;
        }
        return pos + 1;
    }
}
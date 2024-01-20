class Solution{
    static int back(int i, int num, int m) {
        if (i == 0) {
            return 1;
        }
        if (num > m) {
            return 0;
        }
        return back(i, num + 1, m) + back(i - 1, 2 * num, m);
    }
    static int numberSequence(int m, int n)
    {
        return back(n, 1, m);
    }
}
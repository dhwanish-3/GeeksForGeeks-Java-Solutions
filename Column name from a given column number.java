class Solution
{
    String colName (long n)
    {
        String s = "";
        while (n != 0) {
            if (n % 26 == 0) {
                s += 'Z';
                n -= 1;
            } else {
                s +=  (char)((n % 26) + 'A' - 1);
            }
            n /= 26;
        }
        String sol = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            sol += s.charAt(i);
        }
        return sol;
    }
}
class Solution {
    private char solve(String s, int r, int n) {
        if (r == 0) {
            return s.charAt(n);
        }
        char ch = solve(s, r - 1, n / 2);
        if (n % 2 == 0) {
            if (ch == '0') {
                return '0';
            } else {
                return '1';
            }
        } else {
            if (ch == '0') {
                return '1';
            } else {
                return '0';
            }
        }
    }

    public char nthCharacter(String s, int r, int n) {
        return solve(s, r, n);
    }
}
class Solution {
    int countDigit(int num, int x) {
        int count = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == x) {
                count++;
            }
        }
        return count;
    }
    int countX(int L, int R, int X) {
        int count = 0;
        for (int i = L + 1; i < R; i++) {
            count += countDigit(i, X);
        }
        return count;
    }
};
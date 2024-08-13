class Solution {
    long floorSqrt(long n) {
        // Your code here
        long l = 1;
        long r = n + 1;
        while (l < r) {
            long m = (l + r) / 2;
            if (n / m >= m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
}

class Solution2 {
    long floorSqrt(long n) {
        // Your code here
        long sol = 1;
        long sq = 0;
        while (sq < n) {
            sq = sol * sol;
            if (sq > n) {
                break;
            } else {
                sol++;
            }
        }
        return sol - 1;
    }
}

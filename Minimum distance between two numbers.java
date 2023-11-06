class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minDist = Integer.MAX_VALUE;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == x || a[i] == y) {
                if (prev != -1 && a[prev] != a[i]) {
                    minDist = Math.min(minDist, i - prev);
                }
                prev = i;
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
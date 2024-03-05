class Solution{
    static int maxIndexDiff(int a[], int n) { 
        int min[] = new int[n];
        int max[] = new int[n];
        min[0] = a[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], a[i]);
        }
        max[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], a[i]);
        }
        int l = 0, r = 0;
        int sol = Integer.MIN_VALUE;
        while (l < n && r < n) {
            if (min[l] <= max[r]) {
                sol = Math.max(sol, r - l);
                r++;
            } else {
                l++;
            }
        }
        return sol;
    }
}


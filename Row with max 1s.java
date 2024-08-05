class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length, m = arr[0].length;
        int sol = -1;
        int ones = 0;
        int l = 0, r = m - 1;
        while (l < n && r >= 0) {
            if (arr[l][r] == 1) {
                r--;
            } else {
                l++;
            }
            if (m - r - 1 > ones) {
                ones = m - r - 1;
                sol = l;
            }
        }
        return sol;
    }
}
import java.util.ArrayList;

class Solution {
    int mod = 1000000007;
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> pascal = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1L);
                } else {
                    row.add((pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j)) % mod);
                }
            }
            pascal.add(row);
        }
        return pascal.get(n - 1);
    }
}
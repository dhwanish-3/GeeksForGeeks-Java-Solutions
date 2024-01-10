
class Solution {
    static int minCandy(int n, int ratings[]) {
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sol = 0;
        for (int i = 0; i < n; i++) {
            sol += candies[i];
        }
        return sol;
    }

    public static void main(String[] a) {
        int[] ratings = {2, 1, 3, 4, 5};
        int n = ratings.length;
        System.out.println(minCandy(n, ratings));
    }
}

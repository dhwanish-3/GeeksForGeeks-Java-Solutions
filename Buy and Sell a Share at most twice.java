class Solution {
    public static int maxProfit(int n, int[] price) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = Integer.MIN_VALUE;
        int sell2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            buy1 = Math.min(buy1, price[i]);
            sell1 = Math.max(sell1, price[i] - buy1);
            buy2 = Math.min(buy2, price[i] - sell1);
            sell2 = Math.max(sell2, price[i] - buy2);
        }
        return sell2;
    }
}
class Pair {
    int first, second;
    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(price[i], i + 1);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.first - b.first;
            }
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = Math.min(arr[i].second, k / arr[i].first);
            ans += x;
            k -= x * arr[i].first;
        }
        return ans;
    }
}

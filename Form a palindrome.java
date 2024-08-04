class Solution{
    static int rec(String s, int l, int r) {
        if (l == r) return 1;
        if (l > r) return 0;
        if (s.charAt(l) == s.charAt(r)) return 2 + rec(s, l + 1, r - 1);
        else return Math.max(rec(s, l + 1, r), rec(s, l, r - 1));
    }
    static int countMin(String str)
    {
        // code here
        // return str.length() - rec(str, 0, str.length() - 1);
        int n = str.length();
        List<List<Integer>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                dp.get(i).add(0);
            }
        }
        for (int i = 0; i < n + 1; i++) {
            dp.get(i).set(i, 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp.get(i).set(j, 2 + dp.get(i + 1).get(j - 1));
                } else {
                    dp.get(i).set(j, Math.max(dp.get(i + 1).get(j), dp.get(i).get(j - 1)));
                }
            }
        }
        return n - dp.get(0).get(n - 1);
    }
}
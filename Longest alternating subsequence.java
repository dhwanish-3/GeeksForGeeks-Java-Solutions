class Solution {
    private int rec(int[] arr, int i, int prev, int need) {
        if (i == arr.length) return 0;
        if (prev == -1) {
            return Math.max(1 + Math.max(rec(arr, i + 1, i, -1), rec(arr, i + 1, i, 1)), rec(arr, i + 1, prev, need));
        }
        if (need > 0) {
            if (arr[i] > arr[prev]) {
                return Math.max(1 + rec(arr, i + 1, i, -1), rec(arr, i + 1, prev, need));
            } else {
                return rec(arr, i + 1, prev, need);
            }
        } else {
            if (arr[i] < arr[prev]) {
                return Math.max(1 + rec(arr, i + 1, i, 1), rec(arr, i + 1, prev, need));
            } else {
                return rec(arr, i + 1, prev, need);
            }
        }
    }
    public int alternatingMaxLength(int[] arr) {
        // code here
        // return rec(arr, 0, -1, 0);
        int n = arr.size();
        List<List<List<Integer>>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                dp.get(i).add(new ArrayList<>(List.of(0, 0)));
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= 1; prev--) {
                for (int need = 0; need <= 1; need++) {
                    int take = 0;
                    if (prev == -1) {
                        take = 1 + Math.max(dp.get(i + 1).get(i + 1).get(0), dp.get(i + 1).get(i + 1).get(1));
                    } else if (need == 1) {
                        if (arr[i] > arr[prev]) {
                            take = 1 + dp.get(i + 1).get(i + 1).get(0);
                        }
                    } else {
                        if (arr[i] < arr[prev]) {
                            take = 1 + dp.get(i + 1).get(i + 1).get(1);
                        }
                    }
                    int notTake = dp.get(i + 1).get(prev + 1).get(need);
                    dp.get(i).get(prev + 1).set(need, Math.max(take, notTake));
                }
            }
        }
        return Math.max(dp.get(0).get(0).get(0), dp.get(0).get(0).get(1));
    }
    private int alternatingMaxLength(int[] arr) {
        int n = arr.length;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
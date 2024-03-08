class Solution {
    private boolean checkConditions(int[] satified) {
        for (int i = 0; i < satified.length; i++) {
            if (satified[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public int smallestSubstring(String S) {
        int len = S.length();
        int minLen = Integer.MAX_VALUE;
        int[] satified = new int[3];
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '0') {
                satified[0]++;
            } else if (S.charAt(i) == '1') {
                satified[1]++;
            } else if (S.charAt(i) == '2') {
                satified[2]++;
            }
            while (start < len && checkConditions(satified)) {
                minLen = Math.min(minLen, i - start + 1);
                if (S.charAt(start) == '0') {
                    satified[0]--;
                } else if (S.charAt(start) == '1') {
                    satified[1]--;
                } else if (S.charAt(start) == '2') {
                    satified[2]--;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
};
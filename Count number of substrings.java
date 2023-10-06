class Solution
{
    long subCount(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int[] hash = new int[26];
        int countDist = 0;
        long sol = 0;
        while (j < n) {
            hash[s.charAt(j) - 'a']++;
            if (hash[s.charAt(j) - 'a'] == 1) {
                countDist++;
            }
            while (k < countDist) {
                hash[s.charAt(i) - 'a']--;
                if (hash[s.charAt(i) - 'a'] == 0) {
                    countDist--;
                }
                i++;
            }
            j++;
            sol += (j - i + 1);
        }
        return sol;
    }
    long substrCount (String S, int K) {
        return subCount(S, K) - subCount(S, K - 1);
    }
}
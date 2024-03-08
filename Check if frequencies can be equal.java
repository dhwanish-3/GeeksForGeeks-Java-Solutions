class Solution {
    boolean allSameFreq(int[] hash) {
        int curr = -1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                continue;
            } else if (curr == -1) {
                curr = hash[i];
            } else if (curr != hash[i]) {
                return false;
            }
        }
        return true;
    }

    boolean sameFreq(String s) {
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        if (allSameFreq(hash)) {
            return true;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                hash[i]--;
                if (allSameFreq(hash)) {
                    return true;
                }
                hash[i]++;
            }
        }
        return false;
    }
}
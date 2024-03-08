import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private static int helper(int i, String s, HashSet<String> set) {
        if (i == s.length()) {
            return 1;
        }
        for (int j = i; j < s.length(); j++) {
            if (set.contains(s.substring(i, j + 1))) {
                if (helper(j + 1, s, set) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        return helper(0, s, set);
    }
}
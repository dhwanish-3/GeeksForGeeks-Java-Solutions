import java.util.ArrayList;

class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> sol = new ArrayList<>();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            sb.append(text.charAt(i));
            if (sb.length() < pattern.length()) {
                continue;
            } else {
                if (sb.toString().equals(pattern)) {
                    sol.add(i - pattern.length() + 2);
                }
                sb.deleteCharAt(0);
            }
        }
        return sol;
    }
}
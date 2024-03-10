import java.util.HashSet;
import java.util.Set;

class Solution {
    String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (chars.contains(str.charAt(i))) {
                continue;
            }
            sb.append(str.charAt(i));
            chars.add(str.charAt(i));
        }
        return sb.toString();
    }
}
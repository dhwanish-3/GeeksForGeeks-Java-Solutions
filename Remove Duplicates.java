class Solution {
    String removeDups(String str) {
        // code here
        StringBuilder sol = new StringBuilder();
        Set<Character> hash = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hash.count(str.charAt(i)) == 0) {
                sol.append(str.charAt(i));
                hash.add(str.charAt(i));
            }
        }
        return sol.toString();
    }
}
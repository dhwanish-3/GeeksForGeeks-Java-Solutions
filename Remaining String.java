class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        int c = 0, i = 0;
        while(c < count && i < s.length()) {
            if (s.charAt(i) == ch) {
                c++;
            }
            i++;
        }
        return s.substring(i, s.length());
    }
}
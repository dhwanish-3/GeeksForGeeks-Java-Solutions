class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        int hash[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                hash[s.charAt(i) - 'a']++;
            } else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                hash[s.charAt(i) - 'A']++;
            }
        }
        for(int i = 0; i < 26; i++) {
            if(hash[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
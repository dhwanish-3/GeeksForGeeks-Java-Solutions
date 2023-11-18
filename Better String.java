
class Solution {
    private static int distSubSeq(String s) {
        HashMap<Character, Integer> last = new HashMap<>();
        int count = 1;
        for (char ch : s.toCharArray()) {
            int newCount = 2 * count;
            if (last.containsKey(ch)) {
                newCount -= last.get(ch);
            }
            last.put(ch, count);
            count = newCount;
        }
        return count;
    }
    public static String betterString(String str1, String str2) {
        int dist1 = distSubSeq(str1);
        int dist2 = distSubSeq(str2);
        return dist1 > dist2 ? str1 : str2;
    }
}
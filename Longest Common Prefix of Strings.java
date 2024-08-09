class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (j = 0; j < arr[i].length(); j++) {
                if (j >= sb.length() || sb.charAt(j) != arr[i].charAt(j)) {
                    break;
                }
            }
            sb.setLength(j);
            if (sb.length() == 0) return "-1";
        }
        return sb.toString();
    }
}
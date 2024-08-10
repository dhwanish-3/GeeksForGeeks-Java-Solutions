class Solution {
    public boolean isValid(String str) {
        // Write your code here
        String str2 = str.replace("."," ");
        String[] strarr = str2.split(" ");
        if (strarr.length != 4) return false;
        for (String s : strarr){
            if (s.trim().equals("")) return false;
            if (s.length() > 1 && s.startsWith("0")) return false;
            int a = Integer.parseInt(s);
            if (a < 0 || a > 255) return false;
        }
        return true;
    }
}
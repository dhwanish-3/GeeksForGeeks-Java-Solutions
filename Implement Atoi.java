class Solution
{
    int atoi(String s) {
        int len = s.length();
        int i = 0;
        int sign = 1;
        int result = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        for (; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result * 10 + (s.charAt(i) - '0');
            } else {
                return -1;
            }
        }
        return sign * result;
    }
}

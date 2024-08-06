class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if (s == 0 && d > 1) {
            return "-1";
        } else if (s > 9 * d) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        while (d > 0) {
            if (s > 9) {
                sb.append("9");
                s -= 9;
            } else if (s <= 9 && s > 1 && d > 1) {
                sb.append(String.valueOf(s - 1));
                s = 1;
            } else if (s == 1 && d > 1) {
                sb.append("0");
            }
            else if (d == 1 && s <= 9) {
                sb.append(String.valueOf(s));
                s = 0;
            }
            d--;
        }
        return sb.reverse().toString();
    }
}
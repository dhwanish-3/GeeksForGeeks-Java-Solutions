class Solution {
    public boolean func(String a, String b, String n) {
        int st = a.length() + b.length();
        int x = 0;
        for (int i = st; i < n.length();) {
            try {
                x = Integer.parseInt(a) + Integer.parseInt(b);
            } catch (Exception e) {
                {
                    return false;
                }
            }
            String temp = String.valueOf(x);
            for (int j = 0; j < temp.length(); j++) {
                if (i == n.length()) {
                    return false;
                }
                if (n.charAt(i) != temp.charAt(j)) {
                    return false;
                }
                i++;
            }
            a = b;
            b = temp;
        }
        return true;
    }

    public boolean isAdditiveSequence(String n) {
        // code here
        if (n.length() < 3) {
            return false;
        }
        int len = n.length();
        for (int q = 2; q < len; q++) {
            for (int p = 1; p <= q / 2; p++) {
                String a = n.substring(0, p);
                String b = n.substring(p, q);
                if (func(a, b, n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
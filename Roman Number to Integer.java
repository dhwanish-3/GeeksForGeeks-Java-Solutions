class Solution {
    private int roman(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; 
        }
    }
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        int len = str.length();
        int roman = 0;
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && roman(str.charAt(i)) < roman(str.charAt(i + 1))) {
                roman -= roman(str.charAt(i));
            } else {
                roman += roman(str.charAt(i));
            }
        }
        return roman;
    }
}
class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        int n = str1.length();
        int n2 = str2.length();
        if(n != n2) {
            return false;
        }
        String str3 = str1 + str1;
        if(str3.indexOf(str2) == 2 || str3.indexOf(str2) == n - 2) {
            return true;
        }
        return false;
    }
}
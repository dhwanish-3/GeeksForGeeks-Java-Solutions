import java.util.*;

class Solution
{
    private static boolean checkLucky(int n, int i) {
        if (i > n) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return checkLucky(n - (n / i), i + 1);
    }
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        return checkLucky(n, 2);
    }
}
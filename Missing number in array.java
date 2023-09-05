class Solution {
    int missingNumber(int array[], int n) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
            xor ^= i + 1;
        }
        x ^= n;
        return xor;
    }
}
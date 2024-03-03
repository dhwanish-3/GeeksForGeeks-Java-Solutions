class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        int[] hash = new int[201];
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
            if (hash[a[i]] >= k) {
                return a[i];
            }
        }
        return -1;
    } 
}
class Solution{
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        long count = 0;
        int start = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= L && a[i] <= R) {
                p = i - start + 1;
            } else if (a[i] > R) {
                start = i + 1;
                p = 0;
            }
            count += p;
        }
        return count;
    } 
}

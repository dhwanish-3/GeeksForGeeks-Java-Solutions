class Solution
{
    int mod = 1001;
    void shuffleArray(long arr[], int n)
    {
        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] += (arr[i] % mod) * mod;
            arr[2 * i + 1] += (arr[i + n / 2] % mod) * mod;
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= mod;
        }
    }
}
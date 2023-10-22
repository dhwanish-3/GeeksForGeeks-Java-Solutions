class Solution {
    static int isPossible(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int it = arr[i];
            while (it != 0) {
                sum += it % 10;
                it /= 10;
            }
        }
        return sum % 3 == 0 ? 1 : 0;
    }
}
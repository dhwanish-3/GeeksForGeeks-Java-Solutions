// TLE
// class Solution {
//     public static long sumOfPowers(long a, long b) {
//         long sol = 0;
//         for (long i = a; i <= b; i++) {
//             long cur = i;
//             for (long j = 2; j * j <= i; j++) {
//                 while (cur % j == 0) {
//                     sol++;
//                     cur /= j;
//                 }
//             }
//             if (cur > 1) {
//                 sol++;
//             }
//         }
//         return sol;
//     }
// }

import java.util.Arrays;

class Solution {
    static int MAX = 200010;
    static boolean computed = false;
    static long[] small = new long[MAX];

    static void preProcessing() {
        Arrays.fill(small, MAX);
        small[1] = 1;
        for (int i = 2; i < MAX; i++) {
            if (small[i] == MAX) {
                small[i] = i;
                for (int j = i + i; j < MAX; j += i) {
                    small[j] = Math.min(small[j], i);
                }
            }
        }
        computed = true;
    }

    public static long sumOfPowers(long a, long b) {
        if (!computed) {
            preProcessing();
        }

        long sol = 0;
        for (long i = a; i <= b; i++) {
            long cur = i;
            while (cur > 1) {
                sol++;
                cur /= small[(int)cur];
            }
        }
        return sol;
    }
}

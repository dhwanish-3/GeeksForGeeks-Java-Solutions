class Solution{
    static String findLargest(int N, int S){
        if (S == 0) {
            if (N == 1) {
                return "0";
            } else {
                return "-1";
            }
        }
        if (S > 9 * N) {
            return "-1";
        }
        String sol = "";
        for (int i = 0; i < N; i++) {
            if (S >= 9) {
                sol += "9";
                S -= 9;
            } else {
                sol += (char)(48 + S);
                S = 0;
            }
        }
        return sol;
    }
}
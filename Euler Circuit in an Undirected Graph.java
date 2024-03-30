import java.util.ArrayList;

class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        for (ArrayList<Integer> e : adj) {
            if (e.size() % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
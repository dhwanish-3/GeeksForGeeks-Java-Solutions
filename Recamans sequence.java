import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    static ArrayList<Integer> recamanSequence(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 1; i < n; i++) {
            int temp = res.get(i - 1) - i;
            if (temp < 0 || set.contains(temp)) {
                temp = res.get(i - 1) + i;
            }
            res.add(temp);
            set.add(temp);
        }
        return res;
    }
}
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
            int x) {
        Set<Integer> set = new HashSet<>();
        for (int num : head2) {
            set.add(num);
        }
        int count = 0;
        for (int num : head1) {
            if (set.contains(x - num)) {
                count++;
            }
        }
        return count;
    }
}

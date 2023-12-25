import java.util.*;

class Meet implements Comparable<Meet> {
    int start;
    int end;
    int index;
    Meet(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
    public int compareTo(Meet other) {
        if (this.end == other.end) {
            return this.index - other.index;
        }
        return this.end - other.end;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] S, int[] F) {
        ArrayList<Meet> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meets.add(new Meet(S[i], F[i], i));
        }
        Collections.sort(meets);
        ArrayList<Integer> sol = new ArrayList<>();
        int end = meets.get(0).end;
        sol.add(meets.get(0).index + 1);
        for (int i = 1; i < n; i++) {
            if (meets.get(i).start > end) {
                sol.add(meets.get(i).index + 1);
                end = meets.get(i).end;
            }
        }
        Collections.sort(sol);
        return sol;
    }
}
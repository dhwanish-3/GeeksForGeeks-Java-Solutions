import java.util.*;

class Solution{
    private void recursion(int N, List<Integer> sol){
        if(N == 0){
            return;
        }
        sol.add(N - 5);
        recursion(N - 5, sol);
        sol.add(N);
    }
    public List<Integer> pattern(int N){
        List<Integer> sol = new ArrayList<>();
        sol.add(N);
        recursion(N, sol);
        return sol;
    }
}
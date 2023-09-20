import java.util.*;

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        D %= 16;
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(((N << D) | (N >> (16 - D))) & 65535);
        sol.add(((N >> D) | (N << (16 - D))) & 65535);
        return sol;
    }
}
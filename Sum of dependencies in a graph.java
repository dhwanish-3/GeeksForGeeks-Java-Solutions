import java.util.*;

class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int sol = 0;
        for (int i = 0; i < V; i++) {
            sol += adj.get(i).size();
        }
        return sol;
    }
};
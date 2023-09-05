// add elements to 2d list of integers
// get size of array

//I want to add elements to particular index of 2d List
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return adj;
    }
}
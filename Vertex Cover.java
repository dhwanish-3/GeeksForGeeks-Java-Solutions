class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        
        outerloop:
        for(int i = 0; i <= 1 << n; i++){
            for(int j = 0; j < m; j++)
            if(!((1 << (edges[j][0] - 1) & i) != 0 || (1 << (edges[j][1] - 1) & i) != 0)) continue outerloop;
            ans = Math.min(ans, Integer.bitCount(i));
        }
        return ans;
    }
}

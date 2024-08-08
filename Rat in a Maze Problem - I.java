class Solution {
    private void rec(int[][] mat, ArrayList<String> sol, int i, int j, StringBuilder sb, boolean[][] visited) {
        if (i >= mat.length || i < 0 || j >= mat[0].length || j < 0 || mat[i][j] == 0) {
            return;
        }
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            sol.add(sb.toString());
            return;
        }
        if (visited[i][j]) return;
        visited[i][j] = true;
        sb.append("U");
        rec(mat, sol, i - 1, j, sb, visited);
        sb.setLength(sb.length() - 1);
        sb.append("D");
        rec(mat, sol, i + 1, j, sb, visited);
        sb.setLength(sb.length() - 1);
        sb.append("L");
        rec(mat, sol, i, j - 1, sb, visited);
        sb.setLength(sb.length() - 1);
        sb.append("R");
        rec(mat, sol, i, j + 1, sb, visited);
        sb.setLength(sb.length() - 1);
        visited[i][j] = false;
    }
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> sol = new ArrayList<>();
        if (mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            return sol;
        }
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        rec(mat, sol, 0, 0, sb, visited);
        return sol;
    }
}
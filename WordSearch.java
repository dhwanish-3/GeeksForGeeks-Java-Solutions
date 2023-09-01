public class WordSearch {
    static int row, col;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static boolean backtrack(int i, int j, char[][] board, String word, int ind) {
        if (ind >= word.length()) return true;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word.charAt(ind)) return false;
        char t = board[i][j];
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            if (backtrack(i + dx[k], j + dy[k], board, word, ind + 1)) return true;
        }
        board[i][j] = t;
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(i, j, board, word, 0)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}

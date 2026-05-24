// Surrounded Regions

import java.util.Arrays;

public class LeetCode_130 {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','X','O','O'}};
        surroundedRegions(board);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    static void surroundedRegions(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // Check boundary 0 and perform DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n-1 || j == 0 || j == m-1) && board[i][j] == 'O') {
                    dfsLookup(n,m,i,j,visited,board);
                }
            }
        }

        // Convert O's to X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfsLookup(int n,int m,int row,int col,boolean[][] visited,char[][] board) {
        visited[row][col] = true;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for (int i = 0;i<4;i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if ((nr >= 0 && nr < n && nc >= 0 && nc < m) && (board[nr][nc] == 'O' && !visited[nr][nc])) {
                dfsLookup(n,m,nr,nc,visited,board);
            }
        }
    }
}

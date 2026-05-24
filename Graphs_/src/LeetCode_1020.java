// Number of Enclaves

public class LeetCode_1020 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }

    static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        // Traverse boundary elements and look out for 1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n-1 || j == 0 || j == m-1) && (grid[i][j] == 1 && !visited[i][j])) {
                    dfsSearch(n,m,i,j,visited,grid);
                }
            }
        }

        int count = 0;
        // Count for 1's which are not visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) count++;
            }
        }

        return count;
    }

    static void dfsSearch(int n,int m,int i,int j,boolean[][] visited,int[][] grid) {
        visited[i][j] = true;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for (int k = 0; k < 4; k++) {
            int nr = i + delRow[k];
            int nc = j + delCol[k];

            if ((nr >= 0 && nr < n && nc >= 0 && nc < m) && (grid[nr][nc] == 1 && !visited[nr][nc])) {
                dfsSearch(n,m,nr,nc,visited,grid);
            }
        }
    }
}

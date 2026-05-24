// Number of Islands

public class LeetCode_200 {
    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println(numIslands(grid));
    }

    static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    adjacentIslandLookUp(n,m,i,j,visited,grid);
                }
            }
        }

        return islandCount;
    }

    static void adjacentIslandLookUp(int n,int m,int row,int col,boolean[][] visited,char[][] grid) {
        visited[row][col] = true;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if ((nr >= 0 && nr < n && nc >= 0 && nc < m) && (grid[nr][nc] == '1' && !visited[nr][nc])) {
                adjacentIslandLookUp(n,m,nr,nc,visited,grid);
            }
        }
    }
}

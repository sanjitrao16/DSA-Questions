// Max Area of Island

public class LeetCode_695 {
    public static void main(String[] args) {
//        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//        };
        int[][] grid = {
                {0,0,0,0,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int maxAreaIsland = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    area = islandAreaLookUp(n,m,i,j,visited,grid,area);
                    maxAreaIsland = Math.max(area,maxAreaIsland);
                }
            }
        }

        return maxAreaIsland;
    }

    static int islandAreaLookUp(int n,int m,int row,int col,boolean[][] visited,int[][] grid,int maxArea) {
        visited[row][col] = true;
        maxArea++;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if ((nr >= 0 && nr < n && nc >= 0 && nc < m) && (grid[nr][nc] == 1 && !visited[nr][nc])) {
                int area = islandAreaLookUp(n,m,nr,nc,visited,grid,maxArea);
                maxArea = Math.max(maxArea,area);
            }
        }

        return maxArea;
    }
}

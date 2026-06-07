// Longest Increasing Path in a matrix

import java.util.Arrays;

public class LeetCode_329 {
    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};

        System.out.println(longestIncreasingPath(matrix));
    }

    static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n == 1) return 1;

        int[][] dp = new int[m][n];
        for (int[] row: dp) {
            Arrays.fill(row,-1);
        }

        int longestPath = 1;
        for (int i =0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (dp[i][j] == -1) {
                    int path = longestPathUtil(matrix,dp,i,j,m,n);
                    longestPath = Math.max(path,longestPath);
                }
            }
        }

        return longestPath;
    }

    static int longestPathUtil(int[][] matrix,int[][] dp,int row,int col,int m,int n) {
        if (dp[row][col] != -1) return dp[row][col];

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        int longestPath = 1;

        for (int i = 0;i<4;i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (matrix[row][col] < matrix[nr][nc]) {
                    int path = longestPathUtil(matrix,dp,nr,nc,m,n) + 1;
                    longestPath = Math.max(path,longestPath);
                }
            }
        }

        return dp[row][col] = longestPath;
    }
}

// Unique Paths II

import java.util.Arrays;

public class LeetCode_63 {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = {{0,1,0},{0,0,0},{1,1,0}};
        int[][] obstacleGrid = {{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1] == 1) return 0;
        if (m == 1 && n == 1) return 1;

        boolean obstacleFound = false;
        int[][] dp = new int[m][n];
        // Fill rows
        for (int i = 0; i < n; i++) {
            if (obstacleFound) {
                dp[0][i] = 0;
            }
            else if (obstacleGrid[0][i] == 1) {
                dp[0][i] = Integer.MAX_VALUE;
                obstacleFound = true;
            } else {
                dp[0][i] = 1;
            }
        }

        obstacleFound = false;
        // Fill cols
        for (int i = 0; i < m; i++) {
            if (obstacleFound) {
                dp[i][0] = 0;
            }
            else if (obstacleGrid[i][0] == 1) {
                dp[i][0] = Integer.MAX_VALUE;
                obstacleFound = true;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else {
                    if (dp[i-1][j] == Integer.MAX_VALUE && dp[i][j-1] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                    }
                    else if (dp[i-1][j] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i][j-1];
                    }
                    else if (dp[i][j-1] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}

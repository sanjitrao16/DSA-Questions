// Unique Paths

import java.util.Arrays;

public class LeetCode_62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m,n));
    }

    static int uniquePaths(int m,int n) {
        if (m == 1 && n == 1) return 1;
        int[][] dp = new int[m][n];

        // Fill the first rows and cols to 1
        for (int i = 0;i<n;i++) {
            dp[0][i] = 1;
        }
        for (int j =0;j<m;j++) {
            dp[j][0] = 1;
        }

        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}

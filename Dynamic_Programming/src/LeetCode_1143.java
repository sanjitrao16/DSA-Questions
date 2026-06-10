// Longest Common Subsequence

import java.util.Arrays;

public class LeetCode_1143 {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";

        System.out.println(longestCommonSubsequenceTabulation(text1,text2));
    }

    static int longestCommonSubsequenceMemoization(String text1,String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return LCSUtil(text1,text2,dp,0,0);
    }

    static int LCSUtil(String text1,String text2,int[][] dp,int i,int j) {
        if (i == text1.length() || j == text2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + LCSUtil(text1,text2,dp,i+1,j+1);
        }

        return Math.max(LCSUtil(text1,text2,dp,i+1,j),LCSUtil(text1,text2,dp,i,j+1));
    }

    static int longestCommonSubsequenceTabulation(String text1,String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1; // Diagonal element
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}

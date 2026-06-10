// Longest Palindromic Subsequence

import java.util.Arrays;

public class LeetCode_516 {
    public static void main(String[] args) {
        String s = "abacabdbbd";
        System.out.println(longestPalindromicSubsequenceMemo(s));
    }

    static int longestPalindromicSubsequenceMemo(String s) {
        int n = s.length();

        if (n == 1) return 1;

        int[][] dp = new int[n+1][n+1];

        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return LPSMemoUtil(s,dp,0,n-1);
    }

    static int LPSMemoUtil(String s,int[][] dp,int i,int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + LPSMemoUtil(s,dp,i+1,j-1);
        }

        return dp[i][j] = Math.max(LPSMemoUtil(s,dp,i+1,j),LPSMemoUtil(s,dp,i,j-1));
    }

    static int longestPalindromicSubsequenceRecursive(String s) {
        int n = s.length();

        return LPSRecursionUtil(s,0,n-1);
    }

    static int LPSRecursionUtil(String s,int i,int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) return 2 + LPSRecursionUtil(s,i+1,j-1);

        return Math.max(LPSRecursionUtil(s,i+1,j),LPSRecursionUtil(s,i,j-1));
    }
}

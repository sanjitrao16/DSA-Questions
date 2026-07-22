// Edit Distance

import java.util.Arrays;

public class LeetCode_72 {
    public static void main(String[] args) {
        String word1 = "hopping";
        String word2 = "stopping";

        System.out.println(minDistanceDP(word1,word2));
    }

    static int minDistanceDP(String word1,String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int[] row: dp) {
            Arrays.fill(row,-1);
        }

        return editDistanceDP(word1,word2,0,0,dp);
    }

    static int editDistanceDP(String s1,String s2,int i,int j,int[][] dp) {
        if (i == s1.length()) {
            return s2.length()-j;
        }
        if (j == s2.length()) {
            return s1.length()-i;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = editDistanceDP(s1,s2,i+1,j+1,dp);
        } else {
            // 1. Replace
            int d1 = 1 + editDistanceDP(s1,s2,i+1,j+1,dp);
            // 2. Delete
            int d2 = 1 + editDistanceDP(s1,s2,i+1,j,dp);
            // 3. Insert
            int d3 = 1 + editDistanceDP(s1,s2,i,j+1,dp);

            return dp[i][j] = Math.min(d3,Math.min(d1,d2));
        }
    }

    static int minDistanceRecursive(String word1,String word2) {
        return editDistanceR(word1,word2,0,0);
    }

    static int editDistanceR(String s1,String s2,int i,int j) {
        if (i == s1.length()) {
            return s2.length()-j;
        }
        if (j == s2.length()) {
            return s1.length()-i;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return editDistanceR(s1,s2,i+1,j+1);
        } else {
            // 1. Replace
            int d1 = 1 + editDistanceR(s1,s2,i+1,j+1);
            // 2. Delete
            int d2 = 1 + editDistanceR(s1,s2,i+1,j);
            // 3. Insert
            int d3 = 1 + editDistanceR(s1,s2,i,j+1);

            return Math.min(d3,Math.min(d1,d2));
        }
    }
}

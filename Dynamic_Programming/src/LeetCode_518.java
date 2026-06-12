// Coin Change - II

import java.util.Arrays;

public class LeetCode_518 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println(changeMemoization(amount,coins));
    }

    static int changeMemoization(int amount,int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return changeUtilMemo(coins,dp,amount,0);
    }

    static int changeUtilMemo(int[] coins,int[][] dp,int amount,int index) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (index == coins.length) return 0;

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int pick = changeUtilMemo(coins,dp,amount-coins[index],index);
        int notPick = changeUtilMemo(coins,dp,amount,index+1);

        return dp[index][amount] = pick+notPick;
    }

    static int changeRecursion(int amount,int[] coins) {
        return changeUtilRecursion(coins,amount,0);
    }

    static int changeUtilRecursion(int[] coins,int amount,int index) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (index == coins.length) return 0;

        // Pick the coin
        int pick = changeUtilRecursion(coins,amount-coins[index],index);
        // Not-pick the coin forever
        int notPick = changeUtilRecursion(coins,amount,index+1);

        return pick+notPick;
    }
}

// Coin Change

import java.util.Arrays;

public class LeetCode_322 {
    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;

        System.out.println(coinChange(coins,amount));
    }

    // Top-Down Memoization Approach
    static int coinChange(int[] coins,int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo,-1);

        int result = coinChangeUtil(amount,coins,memo);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int coinChangeUtil(int amt,int[] coins,int[] memo) {
        if (amt == 0) return 0;
        if (amt < 0) return Integer.MAX_VALUE;

        if (memo[amt] != -1) return memo[amt];

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            int ans = coinChangeUtil(amt-coin,coins,memo);
            if (ans != Integer.MAX_VALUE) ans += 1;
            minCoins = Math.min(minCoins,ans);
        }

        return memo[amt] = minCoins;
    }
}

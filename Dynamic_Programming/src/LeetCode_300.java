// Length of Longest Increasing Subsequence

import java.util.Arrays;

public class LeetCode_300 {
    public static void main(String[] args) {
//        int[] nums = {7};
//        int[] nums = {7,7,7,7};
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLISMemoization(nums)); // -> TC: O(N*N-1)
    }

    static int lengthOfLISRecursion(int[] nums) {
        if (nums.length == 1) return 1;

        return LISUtil(nums,0,-1);
    }

    static int lengthOfLISMemoization(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int[][] dp = new int[n][n+1];
        for (int[] row: dp) {
            Arrays.fill(row,-1);
        }

        return LISMemoUtil(nums,dp,0,-1);
    }

    static int LISMemoUtil(int[] nums,int[][] dp,int index,int prev) {
        if (index == nums.length) return 0;

        if (dp[index][prev+1] != -1) return dp[index][prev+1];

        int notTaken = LISMemoUtil(nums,dp,index+1,prev);
        int taken = 0;
        if (prev == -1 || nums[index] > nums[prev]) {
            taken = 1 + LISMemoUtil(nums,dp,index+1,index);
        }

        return dp[index][prev+1] = Math.max(notTaken,taken);
    }

    static int LISUtil(int[] nums, int index,int prevInd) {
        if (index == nums.length) return 0;
        int notTakenLength = LISUtil(nums,index+1,prevInd);
        int takenLength = 0;
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            takenLength = 1+LISUtil(nums,index+1,index);
        }

        return Math.max(takenLength,notTakenLength);
    }

    static int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        if (n == 1) return 1;

        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS,lengthOfLISUtil(i,nums,memo));
        }

        return maxLIS;
    }

    static int lengthOfLISUtil(int n,int[] nums,int[] memo) {
        if (n == 0) return 1;

        if (memo[n] != -1) return memo[n];

        int sequence = 1;

        for (int i = n-1; i >= 0; i--) {
            int ans = lengthOfLISUtil(i,nums,memo);

            if (nums[n] > nums[i]) {
                sequence = Math.max(sequence,1+ans);
            }
        }

        return memo[n] = sequence;
    }

    static int lengthOfLISBetter(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int len = 0;

        for (int n: nums) {
            int x = Arrays.binarySearch(tails,0,len,n);
            if (x < 0) {
                x = - (x + 1);
            }

            tails[x] = n;
            if (x == len) {
                len++;
            }
        }

        return len;
    }
}

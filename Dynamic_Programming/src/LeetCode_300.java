// Length of Longest Increasing Subsequence

import java.util.Arrays;

public class LeetCode_300 {
    public static void main(String[] args) {
        int[] nums = {7};
        System.out.println(lengthOfLIS(nums));
    }

    static int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        if (n == 1) return 1;

        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        return lengthOfLISUtil(n-1,nums,memo);
    }

    static int lengthOfLISUtil(int n,int[] nums,int[] memo) {
        if (n == 0) return 1;

        int sequence;
        if (nums[n] > nums[n-1]) {
            sequence = 1 + lengthOfLISUtil(n-1,nums,memo);
        } else {
            sequence = lengthOfLISUtil(n-1,nums,memo);
        }
        return memo[n] = sequence;
    }
}

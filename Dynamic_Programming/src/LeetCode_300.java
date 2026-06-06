// Length of Longest Increasing Subsequence

import java.util.Arrays;

public class LeetCode_300 {
    public static void main(String[] args) {
//        int[] nums = {7};
//        int[] nums = {7,7,7,7};
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLISBetter(nums)); // -> TC: O(N*N-1)
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

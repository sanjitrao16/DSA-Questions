// House Robber

import java.util.Arrays;

public class LeetCode_198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        int n = nums.length;

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] moneyRob = new int[n];
        Arrays.fill(moneyRob,-1);

        int maxSum = Integer.MIN_VALUE;

        for (int i = n-1; i >= 0; i--) {
            int sum = robUtil(i,nums,moneyRob);
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }

    static int robUtil(int n,int[] nums,int[] moneyRob) {
        if (n <= 1) {
            return nums[n];
        }

        if (moneyRob[n] != -1) return moneyRob[n];

        int maxSum = Integer.MIN_VALUE;

        for (int i = n-2;i >= 0;i--) {
            int sum = robUtil(i,nums,moneyRob);
            maxSum = Math.max(maxSum,sum+nums[n]);
        }

        return moneyRob[n] = maxSum;
    }
}

// House Robber - II


import java.util.Arrays;

public class LeetCode_213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(robStreet(nums));
    }

    static int robStreet(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);

        int[] memo1 = new int[n];
        Arrays.fill(memo1,-1);
        int robFirst = robLinear(n - 2, 0, nums, memo1);

        int[] memo2 = new int[n];
        Arrays.fill(memo2,-1);
        int robLast = robLinear(n - 1, 1, nums, memo2);

        return Math.max(robFirst,robLast);
    }

    static int robLinear(int i,int s,int[] nums,int[] memo) {
        if (i < s) {
            return 0;
        }

        if (i == s) {
            return nums[s];
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int skip = robLinear(i - 1, s, nums, memo);
        int rob = robLinear(i - 2, s, nums, memo) + nums[i];

        return memo[i] = Math.max(skip, rob);

    }
}

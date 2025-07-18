// Longest sub-array with sum K

import java.util.HashMap;

public class LeetCode_560 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0};
        System.out.println(subarraySum(nums,0));
    }

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sum = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        sum.put(0,1);
        for (int i=0;i<nums.length;i++) {
            prefixSum += nums[i];

            int diff = prefixSum - k;

            count += sum.getOrDefault(diff,0);

            sum.put(prefixSum,sum.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}

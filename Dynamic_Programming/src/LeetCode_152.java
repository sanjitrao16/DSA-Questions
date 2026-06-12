// Maximum Product subarray

import java.util.Arrays;

public class LeetCode_152 {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,1,-4,0,-3,2};

        System.out.println(maxProduct(nums));
    }

    static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int current = nums[i];

            dpMax[i] = Math.max(current,Math.max(current*dpMax[i-1],current*dpMin[i-1]));
            dpMin[i] = Math.min(current,Math.min(current*dpMax[i-1],current*dpMin[i-1]));
        }

        int maxProduct = nums[0];
        for (int i = 1; i < n; i++) {
            if (dpMax[i] > maxProduct) {
                maxProduct = dpMax[i];
            }
        }

        return maxProduct;
    }
}

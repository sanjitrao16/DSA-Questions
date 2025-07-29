// Find the Smallest Divisor Given a Threshold

import java.util.Arrays;

public class LeetCode_1283 {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;

        System.out.println(smallestDivisor(nums,threshold));
    }

    static int smallestDivisor(int[] nums, int threshold) {
        // Sort the given array
        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[nums.length-1];
        int smallest = end;

        while (start <= end) {
            int mid = start + (end-start)/2;

            // Divide and add
            int divSum = 0;
            for (int num: nums) {
                divSum += (int) Math.ceil((float) num/mid);
            }

            if (divSum == threshold) {
                return mid;
            }

            else if (divSum > threshold) {
                start = mid+1;
            }

            else {
                smallest = Math.min(smallest,mid);
                end = mid-1;
            }
        }

        return smallest;
    }
}

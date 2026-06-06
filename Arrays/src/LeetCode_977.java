// Squares of sorted array

import java.util.Arrays;

public class LeetCode_977 {
    public static void main(String[] args) {
//        int[] nums = {-4,-1,0,3,10};
        int[] nums = {-4};


        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    static int[] sortedSquares(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        int[] result = new int[high+1];
        int index = high;

        while (low <= high) {
            if (Math.abs(nums[low]) > Math.abs(nums[high])) {
                result[index--] = nums[low]*nums[low];
                low++;
            } else {
                result[index--] = nums[high]*nums[high];
                high--;
            }
        }
        return result;
    }
}

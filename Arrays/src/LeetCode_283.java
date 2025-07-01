// Move Zeroes to the end

import java.util.Arrays;

public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4, 3, 0, 5, 0};

        moveZeroesOptimal(nums);

        System.out.println(Arrays.toString(nums));
    }

    /*
    *
    * Time Complexity - O(n)
    * Space Complexity - O(1)
    *
    * */

    // Two Traversals
    static void moveZeroes(int[] nums) {
       int index = 0;
       boolean flag = false;

       for (int i = 0;i<nums.length;i++) {
           if (nums[i] != 0) {
               nums[index] = nums[i];
               index++;
           }
           flag = true;
       }
       if (!flag) return;

       for (int i = index;i<nums.length;i++) {
           nums[i] = 0;
       }
    }

    // One Traversal
    /*
    *
    * TC - O(n)
    * SC - O(1)
    *
    * */
    static void moveZeroesOptimal(int[] nums) {
        int index = 0;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }
}

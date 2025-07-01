import java.util.Arrays;

// Remove Duplicates from Sorted Array
public class LeetCode_26 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        // [1,2,]

        System.out.println(removeDuplicates(arr));
    }

    /*
    *
    * Time Complexity - O(n-1) => O(n)
    * Space Complexity - O(1)
    *
    * */

    static int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 1;i<nums.length;i++) {
            if (nums[i] != nums[i-1]) nums[index++] = nums[i-1];
        }
        nums[index] = nums[nums.length-1];
        System.out.println(Arrays.toString(nums));

        return index+1;
    }
}

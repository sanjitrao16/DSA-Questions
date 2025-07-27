// Find Minimum in Rotated Sorted Array

public class LeetCode_153 {
    public static void main(String[] args) {
//        int[] arr = {4,5,6,7,0,1,2,3};
        int[] arr = {3,1,2};
        System.out.println(findMin(arr));
    }

    /*

    We know in a rotated sorted array, for every index one half is already sorted.

    1. We find the sorted half.
    2. If both halves are sorted then the whole array is sorted, therefore the minimum element is the first element.
    3. In the sorted half the leftmost element is the minimum value.
    4. Eliminate that half and then we search in the remaining half.


     */
    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end-start)/2;

            // Check if both halves are sorted

            if (nums[start] <= nums[end]) {
                ans = Math.min(ans,nums[start]);
                break;
            }

            // Find if left half is sorted
            if (nums[start] <= nums[mid]) {
                ans = Math.min(ans,nums[start]);
                start = mid+1;
            }

            // Right half is sorted
            else {
                ans = Math.min(ans,nums[mid]);
                end = mid-1;
            }
        }

        return ans;
    }
}

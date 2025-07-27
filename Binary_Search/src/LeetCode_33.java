// Search in Rotated Sorted Array

public class LeetCode_33 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,0,0,1,2};
//        System.out.println(searchInRotatedSortedArray(arr,0));
        System.out.println(searchInRotatedSortedArrayII(arr,0));
    }

    /*

    For every index, either of the halves is sorted.

    1. We find the sorted half
    2. Check if the target element is present in the sorted half.

     */
    static int searchInRotatedSortedArray(int[] nums,int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            else if (nums[start] <= nums[mid]) {
                // Check if target is present in the left sorted half
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid-1;
                }

                else {
                    start = mid+1;
                }
            }

            // Then right half is sorted
            else {
                // Check if target is present in the right sorted half
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid+1;
                }

                else {
                    end = mid-1;
                }
            }
        }

        return -1;
    }

    /*

    Similar to the above solution, but there elements are duplicated.
    An edge case occurs when arr[low] == arr[mid] == arr[high], since duplicate elements are possible.

    Therefore, if such case occurs, we increment low and decrement high until the condition dissatisfies.


     */
    static boolean searchInRotatedSortedArrayII(int[] nums,int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start += 1;
                end -= 1;
                continue;
            }

            // Check if left half is sorted
            else if (nums[start] <= nums[mid]) {
                // Check if target is present in the left sorted half
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid-1;
                }

                else {
                    start = mid+1;
                }
            }

            // Then right half is sorted
            else {
                // Check if target is present in the right sorted half
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid+1;
                }

                else {
                    end = mid-1;
                }
            }
        }

        return false;
    }
}

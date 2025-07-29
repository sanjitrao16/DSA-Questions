// Single Element in Sorted Array

public class LeetCode_540 {
    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};

        System.out.println(singleNonDuplicate(arr));
    }

    static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int leftLength;
        int rightLength;

        while (start <= end) {
            int mid = start + (end-start)/2;
            leftLength = mid-1 - start + 1;
            rightLength = end - (mid+1) + 1;

            if (mid > 0 && nums[mid-1] == nums[mid]) {
                if (!((leftLength-1) % 2 == 0)) {
                    end = mid-2;
                }
                else {
                    start = mid+1;
                }
            }

            else if (mid < nums.length-1 && nums[mid] == nums[mid+1]) {
                if (!((rightLength-1) % 2 == 0)) {
                    start = mid+2;
                }

                else {
                    end = mid-1;
                }
            }

            else {
                return nums[mid];
            }
        }
        return -1;
    }
}

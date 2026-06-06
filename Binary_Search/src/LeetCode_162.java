// Finding Peak Element

public class LeetCode_162 {
    public static void main(String[] args) {
//        int[] nums = {1,2,1,3,5,6,4};
        int[] nums = {1,2,3,1};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {3,2,6,7};
//        int[] nums = {1,2};
//        int[] nums = {3,8,6,7};
//        int[] nums = {3,4,3,2,1};

        System.out.println(findPeakElement(nums));
    }

    static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = (low+high)/2;

            if (nums[mid] > nums[mid+1]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return low;
    }
}

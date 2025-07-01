// Check if array is sorted and rotated

public class LeetCode_1752 {
    public static void main(String[] args) {
        int[] nums = {1,4,5,22,11};

        System.out.println(check(nums));
    }

    // Checking if the elements are in increasing fashion and at most
    // one element breaks this pattern, else it isn't sorted

    /*
    *
    * TC - O(n)
    * SC- O(1)
    *
    * */
    static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0;i<n;i++) {
            if (nums[i] > nums[(i+1)%n]) count++;

            if (count > 1) return false;
        }

        return true;
    }
}

// Jump Game

public class LeetCode_55 {
    public static void main(String[] args) {
        int[] nums = {1,2};

        System.out.println(canJump(nums));
    }

    static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int maxJump = nums[0];
        for (int i = 1;i<nums.length;i++) {
            if (i > maxJump) return false;

            if (i+nums[i] > maxJump) {
                maxJump = i+nums[i];
            }

            if (maxJump >= nums.length-1) return true;
        }

        return false;
    }
}

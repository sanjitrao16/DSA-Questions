// Jump Game II

public class LeetCode_45 {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums= {3,0,0,2,1};
//        int[] nums = {1,2};
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
    }

    static int jump(int[] nums) {
        int minJumps = 0;
        int maxJumpIndex = 0;
        int currentEnd = 0;

        for (int i = 0;i<nums.length-1;i++) {
            maxJumpIndex = Math.max(maxJumpIndex,i+nums[i]);

            if (i == currentEnd) {
                minJumps++;
                currentEnd = maxJumpIndex;
            }
        }

        return minJumps;
    }
}

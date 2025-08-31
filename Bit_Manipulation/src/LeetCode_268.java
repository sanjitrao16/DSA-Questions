// Missing Number

public class LeetCode_268 {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumberSolII(nums));
    }

    static int missingNumberSolI(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;

        int sumOfArray = 0;
        for (int num: nums) {
            sumOfArray += num;
        }

        return sum-sumOfArray;
    }

    static int missingNumberSolII(int[] nums) {
        int XOR = 0;
        int n = nums.length;
        for (int i = 0;i<=n;i++) {
            XOR ^= i;
        }

        for (int i: nums) {
            XOR ^= i;
        }

        return XOR;
    }
}

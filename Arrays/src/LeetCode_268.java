// Find the missing number

public class LeetCode_268 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = n*(n+1)/2;
        int arrSum = 0;
        for (int elem: nums) {
            arrSum += elem;
        }

        return sum-arrSum;
    }
}

// Find Max Consecutive Ones

public class LeetCode_485 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1};

        System.out.println(findMaxConsecutiveOnes(arr));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int oneCount = 0;
        int maxCount = 0;

        for (int elem: nums) {
            if (elem == 1) oneCount++;
            else oneCount = 0;

            if (oneCount > maxCount) maxCount = oneCount;
        }

        return maxCount;
    }
}

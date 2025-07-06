// Maximum sum sub-array

// Kadane's Algorithm

import java.util.Arrays;

public class LeetCode_53 {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};

//        System.out.println(maxSubArray(arr));
        System.out.println(Arrays.toString(maxSubArrayII(arr)));
    }

    static int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=0;i<arr.length;i++) {
            sum += arr[i];

            if (sum > maxSum) maxSum = sum;

            if (sum < 0) sum = 0;
        }

        return maxSum;
    }

    static int[] maxSubArrayII(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0;i<arr.length;i++) {
            if (sum == 0) start = i;

            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return Arrays.copyOfRange(arr,ansStart,ansEnd+1);
    }

}

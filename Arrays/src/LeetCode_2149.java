// Rearrange Array Elements by Sign

import java.util.Arrays;

public class LeetCode_2149 {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
//        int[] arr = {-1,1};
//        int[] arr = {-3,-2,1,-1,4,5};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    // Brute-Force Approach
    /*
    *
    * Using Two Temporary Arrays
    *
    * TC - O(n+n/2)
    * SC - O(n)
    *
    * */
    static int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int pIndex = 0;
        int nIndex = 0;

        for (int num: nums) {
            if (num < 0) negative[nIndex++] = num;
            else positive[pIndex++] = num;
        }

        int index = 0;
        pIndex = 0; nIndex = 0;

        while (pIndex < positive.length && nIndex < negative.length) {
            nums[index++] = positive[pIndex++];
            nums[index++] = negative[nIndex++];
        }

        return nums;
    }

    // Optimized Approach
    /*
    *
    * Two-Pointers
    *
    * TC - O(n)
    * SC - O(n)
    *
    * */

    static int[] rearrangeArrayII(int[] nums) {
        int[] result = new int[nums.length];
        int p = 0;
        int n = 1;

        for (int num: nums) {
            if (num < 0) {
                result[n] = num;
                n += 2;
            }
            else {
                result[p] = num;
                p+=2;
            }
        }

        return result;
    }
}

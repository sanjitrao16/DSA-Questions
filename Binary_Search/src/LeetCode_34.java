// Find First and Last Occurrence in sorted array

import java.util.Arrays;

public class LeetCode_34 {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(arr,target)));
    }

    static int[] searchRange(int[] nums,int target) {
        if (nums.length == 0) {
            return new int[] {-1,-1};
        }

        // First Occurrence -> Lower bound
        int first = lowerBound(nums,target);

        // Last Occurrence -> Floor
        int last = findFloor(nums,target);

        return new int[] {first,last};
    }

    static int lowerBound(int[] arr,int x) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == x) {
                ans = mid;
                end = mid-1;
            }

            else if (arr[mid] > x) {
                end = mid-1;
            }

            else {
                start = mid+1;
            }
        }

        return ans;
    }

    static int findFloor(int[] arr,int x) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == x) {
                ans = mid;
                start = mid+1;
            }

            else if (arr[mid] < x) {
                start = mid+1;
            }

            else {
                end = mid-1;
            }
        }

        return ans;
    }
}

// Median of two sorted arrays

public class LeetCode_4 {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    static double findMedianSortedArrays(int[] nums1,int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m+n == 0) return 0.0;

        int mid = (m+n)/2;
        int nextMid = mid+1;
        int i = 0;
        int j = 0;
        int itr = 0;
        int prev = 0;
        int curr = 0;

        while (i < m && j < n) {
            if (itr == nextMid) break;
            if (nums1[i] <= nums2[j]) {
                itr++;
                if (itr == mid) prev = nums1[i];
                else if (itr == nextMid) curr = nums1[i];
                i++;
            } else {
                itr++;
                if (itr == mid) prev = nums2[j];
                else if (itr == nextMid) curr = nums2[j];
                j++;
            }
        }

        while (i < m) {
            if (itr == nextMid) break;
            itr++;
            if (itr == mid) prev = nums1[i];
            else if (itr == nextMid) curr = nums1[i];
            i++;
        }

        while (j < n) {
            if (itr == nextMid) break;
            itr++;
            if (itr == mid) prev = nums2[j];
            else if (itr == nextMid) curr = nums2[j];
            j++;
        }

        if ((m+n) % 2 == 0) return (double) (prev+curr)/2;
        return curr;
    }
}

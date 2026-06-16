// Peak Index in a Mountain Array

public class LeetCode_852 {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l+r)/2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }

            if (arr[mid] < arr[mid-1]) {
                r = mid;
            } else if (arr[mid] < arr[mid+1]) {
                l = mid+1;
            }
        }
        return -1;
    }
}

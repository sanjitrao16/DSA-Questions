// Search Insert Position

public class LeetCode_35 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,9,10,12,15};

        System.out.println(searchInsert(arr,8));
    }

    static int searchInsert(int[] arr,int target) {
        int start = 0;
        int end = arr.length-1;
        int pos = arr.length;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] >= target) {
                pos = mid;
                end = mid-1;
            }

            else {
                start = mid+1;
            }
        }

        return pos;
    }
}

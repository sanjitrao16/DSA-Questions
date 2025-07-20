public class Miscellaneous {
    public static void main(String[] args) {
        int[] arr = {3,5,8,9,15,19};
        System.out.println(upperBound(arr,9));
    }

    static int lowerBound(int[] arr,int x) {
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] >= x) {
                ans = mid;
                end = mid-1;
            }

            else {
                start = mid+1;
            }
        }

        return ans;
    }

    static int upperBound(int[] arr,int x) {
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] > x) {
                ans = mid;
                end = mid-1;
            }

            else {
                start = mid+1;
            }
        }

        return ans;
    }
}

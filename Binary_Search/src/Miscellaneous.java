import java.util.Arrays;

public class Miscellaneous {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
//        System.out.println(upperBound(arr,9));
        System.out.println(Arrays.toString(floorCeilArray(arr,5)));
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

    static int[] floorCeilArray(int[] arr,int x) {
        int f = getFloor(arr,x);
        int c = getCeil(arr,x);

        return new int[] {f,c};
    }

    static int getFloor(int[] arr,int x) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] <= x) {
                ans = arr[mid];
                start = mid+1;
            }

            else {
                end = mid-1;
            }
        }

        return ans;
    }

    static int getCeil(int[] arr,int x) {
        // Lower-Bound Algorithm
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

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
}

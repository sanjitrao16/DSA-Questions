import java.util.Arrays;

public class Miscellaneous {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
//        System.out.println(upperBound(arr,9));
//        System.out.println(Arrays.toString(floorCeilArray(arr,5)));
        int[][] matrix = {{0,1,1,1},{0,0,1,1},{1,1,1,1}};

        System.out.println(findMaxOnes(matrix));
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

    // Find the row with maximum number of 1's
    static int findMaxOnes(int[][] mat) {
        int maxOneRow = -1;
        int maxOneCount = 0;
        for (int i = 0;i < mat.length; i++) {
            int start = 0;
            int end = mat[i].length-1;
            int oneCount = 0;

            while (start <= end) {
                int mid = start + (end-start)/2;

                if (mat[i][mid] == 1) {
                    oneCount += end-mid+1;
                    end = mid-1;
                }

                else {
                    start = mid+1;
                }
            }

            if (oneCount > 0 && Math.max(oneCount,maxOneCount) == oneCount) {
                maxOneRow = i;
                maxOneCount = oneCount;
            }
        }

        return maxOneRow;
    }
}

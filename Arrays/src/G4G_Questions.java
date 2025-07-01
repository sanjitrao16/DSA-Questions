import java.util.Arrays;

public class G4G_Questions {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotateArrayRight(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    // Reverse an Array

    /*
    *
    * Using Two Pointers
    * TC - O(n/2) => O(n)
    * SC - O(1)
    *
    * */
    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Rotate an Array
    /*
    *
    * By Reversing arrays
    *
    * TC - O(n)
    * SC - O(1)
    *
    * */
    static void rotateArrayLeft(int[] arr, int d) {
        int index = d % arr.length;

        //Reverse the first index-1 elements
        reverseKElements(arr,0,index-1);
        //Reverse the remaining elements
        reverseKElements(arr,index,arr.length-1);
        //Reverse whole array
        reverseArray(arr);
    }

    static void reverseKElements(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void rotateArrayRight(int[] arr,int k) {
        k %= arr.length;

        // Reverse whole array
        reverseArray(arr);
        // Reverse the first k-1 elements
        reverseKElements(arr,0,k-1);
        // Reverse the remaining
        reverseKElements(arr,k,arr.length-1);
    }

    // Second Largest element in array
    static int getSecondLargest(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 1;i<arr.length;i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        return (secondMax == Integer.MIN_VALUE) ? -1:secondMax;
    }
}

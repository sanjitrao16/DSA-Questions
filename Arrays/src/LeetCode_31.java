// Next Permutation

import java.util.Arrays;

public class LeetCode_31 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *
    * Find the right-most element smaller than next element. = pivot
    * Find the right-most element greater than pivot.
    * Swap pivot and that element.
    * Reverse the elements after pivot.
    *
    * */
    static void nextPermutation(int[] arr) {
        int n = arr.length;

        // Finding right-most element smaller than next element
        int pivot = -1;
        for (int i = n-2;i>=0;i--) {
            if (arr[i] < arr[i+1]) {
                pivot = i;
                break;
            }
        }

        //If no pivot then reverse whole array
        if (pivot == -1) {
            reverseArray(arr,0,n-1);
        }

        // Find right-most element greater than pivot
        for (int i = n-1;i>pivot;i++) {
            if (arr[i] > arr[pivot]) {
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }

        // Reverse array after pivot index
        reverseArray(arr,pivot+1,n-1);
    }

    static void reverseArray(int[] arr,int s,int e) {
        while (s<e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }
}

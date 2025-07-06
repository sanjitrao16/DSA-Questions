// Sort Colors 0,1,2

import java.util.Arrays;

public class LeetCode_75 {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortColors(int[] arr) {
        int l = 0, mid = 0, h = arr.length-1;

        while (mid <= h) {
            if (arr[mid] == 0) {
                swap(arr,mid,l);
                l++;
                mid++;
            }

            else if (arr[mid] == 1) {
                mid++;
            }

            else {
                swap(arr,mid,h);
                h--;
            }
        }
    }

    static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

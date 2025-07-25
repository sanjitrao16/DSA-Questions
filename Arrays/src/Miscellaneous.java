import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Miscellaneous {
    public static void main(String[] args) {
        int[] arr1 = {-7,8};
        int[] arr2 = {-8,-3,8};

//        System.out.println(Arrays.toString(unionOfTwoArrays(arr1,arr2)));
//        System.out.println(unionOfTwoSortedArraysAnother(arr1,arr2));

//        int[] arr3 = {10, 5, 2, 7, 1, -10};
        int[] arr3 = {2,0,0,3};
//        System.out.println(longestSubarrayWithSum(arr3,3));

        int[] arr4 = {10, 22, 12, 3, 0, 6};
        System.out.println(leadersOfArrayOptimized(arr4));
    }

    // 1. Union of two sorted arrays

    static int[] unionOfTwoArrays(int[] arr1,int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] union = new int[arr1.length+arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i<n && j<m) {
            if (arr1[i] < arr2[j]) {
                if (union[k] == arr1[i]) continue;

                union[k] = arr1[i];
                i++;
                k++;
            }

            else if (arr1[i] == arr2[j]) {
                if (union[k] == arr2[i]) continue;

                union[k] = arr1[i];
                i++;
                j++;
                k++;
            }

            else {
                if (union[k] == arr2[j]) continue;

                union[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i<n) {
            if (union[k] == arr1[i]) continue;
            union[k] = arr1[i];
            k++;
            i++;
        }

        while (j<m) {
            if (union[k] == arr2[j]) continue;
            union[k] = arr2[j];
            k++;
            j++;
        }

        return union;
    }

    static ArrayList<Integer> unionOfTwoSortedArraysAnother(int[] a,int[] b) {
        int n = a.length;
        int m = b.length;

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i<n && j<m) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.get(union.size()-1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
            }
            else {
                if (union.size() == 0 || union.get(union.size()-1) != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i<n) {
            if (union.size() == 0 || union.get(union.size()-1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }

        while (j<m) {
            if (union.size() == 0 || union.get(union.size()-1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }

    // Longest subarray with given sum K (positive+negatives)
    /*
    *
    * Using Hashing
    *
    * */

    // Similarly for only positives the optimal solution would be two pointers

    static int longestSubarrayWithSum(int[] arr,int k) {
        HashMap<Integer,Integer> sum = new HashMap<>();
        int prefixSum = 0;
        int length = 0;

        for (int i = 0;i<arr.length;i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                length = i+1;
            }

            int diff = prefixSum - k;

            if (sum.containsKey(diff)) {
                length = Math.max(length,i-sum.get(diff));
            }

            if (!(sum.containsKey(prefixSum))) {
                sum.put(prefixSum,i);
            }
        }

        return length;
    }

    // Leaders of the Array
    /*
    *
    * Are elements where the element is greater than all the elements to its RHS.
    *
    *
    * Brute-Force Approach
    *
    * TC - O(n*(n-1)) => O(n^2)
    * SC - O(n)
    *
    * */
    static ArrayList<Integer> leadersOfArray(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        boolean flag = false;

        for (int i = 0;i<arr.length;i++) {
            flag = true;
            for (int j = i+1;j<arr.length;j++) {
                if (!(arr[i] > arr[j])) flag = false;
            }

            if (flag) {
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }

    // Leaders of the array - Optimized Approach
    /*
    *
    *
    * */
    static ArrayList<Integer> leadersOfArrayOptimized(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        int max = arr[n-1];
        leaders.add(max);

        for (int i = n-2;i>=0;i--) {
            if (arr[i] > max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }

        return leaders;
    }
}

//Contains Duplicate

import java.util.HashSet;
import java.util.Arrays;

public class LeetCode_217 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        System.out.println(containsDuplicateUsingSorting(arr));
    }

    // Using Hash-Set
    /*
    Time Complexity - O(n)
    Space Complexity - O(n)
    */
    static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> map = new HashSet<>();

        for (int elem: arr) {
            if (map.contains(elem)) return true;
            else map.add(elem);
        }

        return false;
    }

    // Using Sorting
    /*
    * Time Complexity - O(nlogn + n) => O(nlogn)
    * Space Complexity - O(1)
    *  */
    static boolean containsDuplicateUsingSorting(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1;i<arr.length;i++) {
            if (arr[i]-arr[i-1] == 0) return true;
        }

        return false;
    }
}

// Longest consecutive Sequence

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_128 {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5, 7, 6};
        System.out.println(longestConsecutiveOptimized(arr));
    }

    /*
    * Brute-Force Approach
    *
    * 1. Sort the array
    * 2. Traverse the array, if the difference is 1 it is consecutive.
    *
    * TC - O(nlogn + n)
    * SC - O(1)
    *
    * */
    static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);

        int consecutive = 1;
        int longConsecutive = 1;

        for (int i = 0;i<arr.length-1;i++) {
            if (arr[i+1]-arr[i] == 1) {
                consecutive++;
            }

            else if (arr[i+1]-arr[i] == 0) continue;

            else {
                longConsecutive = Math.max(longConsecutive,consecutive);
                consecutive = 1;
            }
        }

        longConsecutive = Math.max(longConsecutive,consecutive);
        return longConsecutive;
    }

    /*
    *
    * Optimal Approach
    *
    * Using HashSet
    *
    * */
    static int longestConsecutiveOptimized(int[] arr) {
        if (arr.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        // Include all array elements in set
        for (int i: arr) {
            set.add(i);
        }

        int longConsecutive = 1;

        for (int i: set) {
            if (!set.contains(i-1)) {
                int consecutive = 1;
                int x = i;
                while (set.contains(x+1)) {
                    x = x+1;
                    consecutive++;
                }

                longConsecutive = Math.max(longConsecutive,consecutive);
            }
        }

        return longConsecutive;
    }
}

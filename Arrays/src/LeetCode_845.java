// Longest Mountain in Array

public class LeetCode_845 {
    public static void main(String[] args) {
        int[] arr = {1,4,6,3,7,9,10,8,6,5,4};
        System.out.println(longestMountain(arr));
    }

    static int longestMountain(int[] arr) {
        int n = arr.length;
        int low = 0;
        int maxRange = 0;

        while (low < n) {
            int peak = low;
            while (peak + 1 < n && arr[peak] < arr[peak+1]) {
                peak++;
            }

            if (peak > low) {
                int high = peak;
                while (high + 1 < n && arr[high] > arr[high+1]) {
                    high++;
                }

                if (high > peak) {
                    maxRange = Math.max(maxRange,high-low+1);

                    low = high;
                    continue;
                }
            }
            low++;
        }
        return maxRange;
    }
}

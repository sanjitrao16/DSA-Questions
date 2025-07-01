// Two Sum

import java.util.Arrays;
import java.util.HashMap;
public class LeetCode_1 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

    // Using Hash-Maps
    /*
    * Time Complexity - O(n)
    * Space Complexity - O(n)
    *
    *
    * Brute-Force Time Complexity - O(n^2) and Space - O(1)
    * */
    static int[] twoSum(int[] arr,int target) {
        HashMap<Integer,Integer> indices = new HashMap<>();

        for (int i = 0;i<arr.length;i++) {
            int num = arr[i];

            if (indices.containsKey(target - num)) {
                return new int[] {i,indices.get(target-num)};
            }

            indices.put(num,i);
        }
        return new int[] {};
    }
}

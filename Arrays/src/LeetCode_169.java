// Majority Element

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_169 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};

        System.out.println(majorityElementIII(arr));
    }

    // Brute-Force : Using Hash-Maps
    static int majorityElement(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<arr.length;i++) {
            if (!(map.containsKey(arr[i]))) {
                map.put(arr[i],1);
            }

            map.put(arr[i],map.get(arr[i])+1);
        }

        int majority = 0;
        int majorityVal = 0;

        for (int i: map.keySet()) {
            int val = map.get(i);
            if (val > Math.floor(arr.length/2)) {
                return i;
            }
        }

        return -1;
    }

    // Alternate approach -
    // Sort it and count
    static int majorityElementII(int[] arr) {
        // 0 0 2 5 5 5 5
        Arrays.sort(arr);
        int count = 1;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count > n / 2) return arr[i - 1];
                count = 1;
            }
        }
        return (count > n/2) ? arr[n-1]:-1;
    }

    // Moore's Counting Alogrithm

    static int majorityElementIII(int[] arr) {
        int n = arr.length;
        int count = 0;
        int candidate = -1;

        for (int num: arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }

            else if (num == candidate) {
                count ++;
            }

            else {
                count--;
            }
        }

        //Validate the candidate

        count = 0;
        for (int num: arr) {
            if (num == candidate) count++;
        }

        return (count>n/2) ? candidate:-1;
    }
}

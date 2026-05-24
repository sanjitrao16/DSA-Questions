// Difference of two arrays

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_2215 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,3};
        int[] arr2 = {1,1,2,2};

        List<List<Integer>> result = findDifference(arr1,arr2);
        System.out.println(result);
    }

    static List<List<Integer>> findDifference(int[] nums1,int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int num: nums1) {
            setA.add(num);
        }

        for (int num: nums2) {
            setB.add(num);
        }

        // A - B
        List<Integer> setADiff = new ArrayList<>();
        for (int j : setA) {
            if (!setB.contains(j)) {
                setADiff.add(j);
            }
        }

        // B - A
        List<Integer> setBDiff = new ArrayList<>();
        for (int j : setB) {
            if (!setA.contains(j)) {
                setBDiff.add(j);
            }
        }

        result.add(setADiff);
        result.add(setBDiff);

        return result;
    }
}

// Least Number of Unique Integers after K Removals

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeetCode_1481 {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;

        System.out.println(findLeastNumOfUniqueInts(arr,k));
    }

    static int findLeastNumOfUniqueInts(int[] arr,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n: arr) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int val: map.values()) {
            list.add(val);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (k > list.get(i)) {
                k -= list.get(i);
                list.set(i,0);
            } else {
                list.set(i,list.get(i)-k);
                k = 0;
            }

            if (list.get(i) != 0) count++;
        }

        return count;
    }
}

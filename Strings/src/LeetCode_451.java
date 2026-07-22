// Sort Characters by frequency

import java.util.HashMap;
import java.util.Map;

public class LeetCode_451 {
    public static void main(String[] args) {
        String s = "tree";

        System.out.println(frequencySort(s));
    }

    static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (char ch: s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch,1);
            }
            else {
                map.put(ch,map.get(ch)+1);
            }
        }

        StringBuilder result = new StringBuilder();
        int maxCount = 0;

        for (Map.Entry<Character,Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount) {

            }
        }
    }
}

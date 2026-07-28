// Sort Characters by frequency

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LeetCode_451 {
    public static void main(String[] args) {
        String s = "tree";

        System.out.println(frequencySort(s));
    }

    static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b)-map.get(a));

        StringBuilder sb = new StringBuilder();
        for (char ch: list) {
            int count = map.get(ch);
            for (int i = 0;i<count;i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

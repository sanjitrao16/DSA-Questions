// Isomorphic Strings

import java.util.HashMap;

public class LeetCode_205 {
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";

        System.out.println(isIsomorphic(s,t));
    }

    static boolean isIsomorphic(String s,String t) {
        HashMap<Character,Character> table = new HashMap<>();

        for (int i =0;i<s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (table.containsKey(c1)) {
                if (!(table.get(c1) == c2)) {
                    return false;
                }
            }

            else if (table.containsValue(c2)) return false;
            table.put(c1,c2);
        }
        return true;
    }
}

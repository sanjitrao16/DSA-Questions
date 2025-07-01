// Valid Anagram

import java.util.HashMap;

public class LeetCode_242 {
    public static void main(String[] args) {
        String s = "ggii";
        String t = "eekk";

        System.out.println(isAnagram(s,t));
    }

    // Using Hash-Maps
    /*
    * Time Complexity - O(2n) => O(n)
    * Space Complexity - O(n)
    *
    * */
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0;i<s.length();i++) {
          map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0;i<t.length();i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0) map.remove(t.charAt(i));
            }
        }

        if (map.isEmpty()) return true;
        return false;
    }
}

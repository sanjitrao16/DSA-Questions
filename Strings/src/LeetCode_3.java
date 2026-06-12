// Longest substring without repeating characters

import java.util.HashMap;

public class LeetCode_3 {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r),r);
                maxLen = Math.max(maxLen,r-l+1);
            } else {
                if (map.get(s.charAt(r)) >= l) {
                    l = map.get(s.charAt(r)) + 1;
                }

                maxLen = Math.max(maxLen,r-l+1);
                map.put(s.charAt(r),r);
            }
            r++;
        }

        return maxLen;
    }
}

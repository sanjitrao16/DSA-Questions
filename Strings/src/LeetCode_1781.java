// Sum of Beauty of all substrings

import java.util.HashMap;

public class LeetCode_1781 {
    public static void main(String[] args) {
        String s = "aabcbaa";

        System.out.println(beautySum(s));
    }

    /*

    Brute-Force Approach

     */
    static int beautySum(String s) {
        int sumOfBeauty = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length()-1; i++) {
            freq.clear();
            freq.put(s.charAt(i),1);
            int high = 1;
            int low = 1;
            for (int j = i+1; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (!(freq.containsKey(ch))) {
                    freq.put(ch,1);
                    low = Math.min(low,freq.get(ch));
                }

                else {
                    freq.put(ch,freq.get(ch)+1);
                    high = Math.max(high,freq.get(ch));
                    if (freq.size() == 1) low = freq.get(ch);
                    else low = Math.min(low,freq.get(ch));
                }
                sumOfBeauty += (high-low);
            }
        }
        return sumOfBeauty;
    }
}

// Smallest Palindromic Rearrangement I

import java.util.Arrays;

public class LeetCode_3517 {
    public static void main(String[] args) {
        String s = "daccad";
        System.out.println(smallestPalindrome(s));
    }

    static String smallestPalindrome(String s) {
        int[] charFreq = new int[26];

        for (char c: s.toCharArray()) {
            charFreq[c - 'a'] += 1;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (charFreq[i] == 0) continue;

            char c = (char) ('a'+i);
            int halfCount = charFreq[i]/2;
            for (int j = 0;j<halfCount;j++) {
                left.append(c);
            }

            if (charFreq[i] % 2 != 0) {
                middle = String.valueOf(c);
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString()+middle+right.toString();
    }
}

// Count the number of consistent strings

import java.util.HashSet;

public class LeetCode_1684 {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(allowed,words));
    }

    static int countConsistentStrings(String allowed,String[] words) {
        HashSet<Character> characters = new HashSet<>();

        for (char c: allowed.toCharArray()) {
            characters.add(c);
        }

        int count = 0;
        for (String word: words) {
            boolean flag = true;
            for (char ch: word.toCharArray()) {
                if (!characters.contains(ch)) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        return count;
    }
}

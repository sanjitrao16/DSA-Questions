import java.util.Arrays;
import java.util.Set;
import java.lang.StringBuilder;
import java.util.LinkedHashSet;

public class LeetCode_14 {
    public static void main(String[] args) {
        String[] strs = {"reflower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        Set<Character> charSet = new LinkedHashSet<>();
        Arrays.sort(strs);
        String first = strs[0];

        for (char c: first.toCharArray()) {
            charSet.add(c);
        }

        for (int i = 1;i<strs.length;i++) {
            charSet = helperFunction(strs[i],charSet);
            if (charSet.isEmpty()) return "";
        }

        StringBuilder result = new StringBuilder();
        for (Character c: charSet) {
            result.append(c);
        }

        return result.toString();
    }

    static Set<Character> helperFunction(String str,Set<Character> set) {
        Set<Character> result = new LinkedHashSet<>();
        for (char c: str.toCharArray()) {
            if (set.contains(c)) {
                result.add(c);
            } else {
                break;
            }
        }

        return result;
    }
}

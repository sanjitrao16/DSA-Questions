// Longest Common Prefix String
public class LeetCode_14 {
    public static void main(String[] args) {
        String[] strs = {"flower","","flight"};
//        String[] strs = {"aa","aa"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int n = prefix.length();

        for (int i = 1;i< strs.length;i++) {
            String curr = strs[i];
            int ptr = 0;

            while (ptr < n && ptr < curr.length()) {
                if (prefix.charAt(ptr) == curr.charAt(ptr)) {
                    ptr++;
                } else {
                    break;
                }
            }

            n = ptr;

            if (ptr == 0) {
                return "";
            }
        }

        return prefix.substring(0,n);
    }
}

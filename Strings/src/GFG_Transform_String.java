/*
Given two strings A and B. Find the minimum number of steps required to transform string A into
string B. The only allowed operation for the transformation is selecting a character from string A
and inserting it in the beginning of string A
 */


public class GFG_Transform_String {
    public static void main(String[] args) {
        String s1 = "GeeksForGeeks";
        String s2 = "ForGeeksGeeks";

        System.out.println(transform(s1,s2));
    }

    static int transform(String s1,String s2) {
        if (s1.length() != s2.length()) return -1;

        // Checking if they are anagrams
        int[] count = new int[256];

        for(int i =0;i<s1.length();i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i:count) {
            if (i != 0) return -1;
        }

        int minTransform = 0;
        int i = s1.length()-1;
        int j = s1.length()-1;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                minTransform++;
                i--;
            }
        }

        return minTransform;
    }
}

// Reverse Words in a string

public class LeetCode_151 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        s = s.trim();
        int start = s.length()-1;
        int end = s.length();

        StringBuilder result = new StringBuilder();

        while (start >= 0) {
            if (s.charAt(start) != ' ') {
                start--;
            }

            else {
                if (end-start == 1 && s.charAt(end) == ' ') {
                    end = start;
                    start--;
                }

                else if (start != end) {
                    result.append(s.substring(start+1,end));
                    result.append(" ");
                    end = start;
                    start--;
                }
            }
        }

        result.append(s.substring(start+1,end));

        return result.toString();
    }
}

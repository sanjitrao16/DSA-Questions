// Largest Odd Number in String

public class LeetCode_1903 {
    public static void main(String[] args) {
        String num = "42";
        System.out.println(largestOddNumber(num));
    }

    static String largestOddNumber(String num) {
        int start = num.length()-1;
        int end = num.length();

        while (start >= 0) {
            if ((num.charAt(start) - '0') % 2 != 0) {
                return num.substring(0,end);
            }

            start--;
            end--;
        }

        return "";
    }
}

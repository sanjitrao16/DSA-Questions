import java.lang.StringBuilder;

public class Misc {
    public static void main(String[] args) {
//        String s = "thw$ g##bhdwd vfg*gh$vvdd#bdudhc";
        String s = "     a#bghft$$$srtd*sf*t fhf####    ght";
        System.out.println(convertGoodString(s));
    }

    static String convertGoodString(String s) {
        StringBuilder result = new StringBuilder();

        int start = 0;
        int end = 0;
        int count = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            if (Character.isLetter(c)) {
                if (start != end) {
                    end += count;
                    count = 0;
                    start = end;
                }

                else {
                    result.append(c);
                    start++;
                    end++;
                }
            }

            else if (c == '*' || c == '#' || c == '$') {
                end++;
                count++;
            }

            else {
                result.append(c);
                start++;
                end++;
            }
        }

        return result.toString();
    }
}

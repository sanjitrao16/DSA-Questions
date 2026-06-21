// Backspace String compare

import java.util.Stack;

public class LeetCode_844 {
    public static void main(String[] args) {
        String s = "#a#";
        String t = "ab##b";

        System.out.println(backspaceCompare(s,t));
    }

    static boolean backspaceCompare(String s,String t) {
        Stack<Character> stack = new Stack<>();

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (stack.isEmpty() && c == '#') {
                continue;
            }
            else if (c == '#') stack.pop();
            else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            str1.append(stack.pop());
        }

        for (char c: t.toCharArray()) {
            if (stack.isEmpty() && c == '#') {
                continue;
            }
            else if (c == '#') stack.pop();
            else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            str2.append(stack.pop());
        }

        return str1.toString().compareTo(str2.toString()) == 0;
    }
}

// Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22 {
    public static void main(String[] args) {
        int n = 6;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }

    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int open = 1;
        int close = 0;

        return helperFunc(n,sb,open,close,result);
    }

    static List<String> helperFunc(int n,StringBuilder sb,int open,int close,List<String> result) {
        if (open > n || close > open) {
            return result;
        }

        if (open == n && close == n) result.add(sb.toString());

        helperFunc(n,new StringBuilder().append(sb).append("("),open+1,close,result);
        helperFunc(n,new StringBuilder().append(sb).append(")"),open,close+1,result);

        return result;
    }
}

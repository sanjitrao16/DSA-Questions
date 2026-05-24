// Fibonacci Number

import java.util.Arrays;

public class LeetCode_509 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(fib(n));
    }

    static int fib(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);

        return helperFib(n,memo);
    }

    static int helperFib(int n,int[] memo) {
        if (n <= 1) return n;

        if (memo[n] != -1) return memo[n];

        memo[n] = helperFib(n-1,memo) + helperFib(n-2,memo);
        return memo[n];
    }
}

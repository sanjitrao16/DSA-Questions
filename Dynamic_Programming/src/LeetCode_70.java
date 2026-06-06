// Climbing Stairs

public class LeetCode_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    static int climbStairs(int n) {
        if (n <= 2) return n;

        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;

        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n-1];
    }
}

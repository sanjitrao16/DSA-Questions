// Power of Two

public class LeetCode_231 {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPowerofTwo(n));
    }

    static boolean isPowerofTwo(int n) {
        return ((n & n-1) == 0);
    }
}

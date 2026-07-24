// Egg Drop with 2 Eggs and N Floors

public class LeetCode_1884 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(twoEggDrop(n));
    }

    static int twoEggDrop(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int i = 0;
        while (n > 0) {
            n = n-i;
            i++;
        }

        return i-1;
    }
}

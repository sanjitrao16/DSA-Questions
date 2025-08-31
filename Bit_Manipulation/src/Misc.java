public class Misc {
    public static void main(String[] args) {
        int n = 11; //1011
        System.out.println(nthBitOfNumber(n,2));
        System.out.println(checkIthBitIsSet(n,2));
        System.out.println(isEven(n));


        // Swap two numbers
        int x = 3;
        int y = 4;
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println("X: "+x);
        System.out.println("Y: "+y);
    }

    // Find nth bit of the number
    static int nthBitOfNumber(int n,int i) {
        int power = (int) Math.pow(2,i);
        return ((n & power) == power) ? 1:0;
    }

    // Check ith bit is set or not
    static boolean checkIthBitIsSet(int n,int i) {
        int power = (int) Math.pow(2,i);
        return ((n & power) == power);
    }

    // Check if number is even
    static boolean isEven(int n) {
        return ((n & 1) == 0);
    }
}

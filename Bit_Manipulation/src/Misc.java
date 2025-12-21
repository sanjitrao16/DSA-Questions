public class Misc {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(nthBitOfNumber(n,2));
        System.out.println(checkIthBitIsSet(n,2));
        System.out.println(isEven(n));
        System.out.println(setIthBit(10,2));
        System.out.println(unSetIthBit(10,1));
        System.out.println(countSetBits(12));


        // Swap two numbers
//        int x = 3;
//        int y = 4;
//        x ^= y;
//        y ^= x;
//        x ^= y;
//        System.out.println("X: "+x);
//        System.out.println("Y: "+y);
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

    static int setIthBit(int n,int i) {
        int mask = (int) Math.pow(2,i);
        return n | mask;
    }

    static int unSetIthBit(int n,int i) {
        int mask = (int) Math.pow(2,i);
        return n & (~mask);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }

        return count;
    }
}

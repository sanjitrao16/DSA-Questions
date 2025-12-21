// Minimum Bit Flips to Convert number

public class LeetCode_2220 {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(minBitFlips(start,goal));
    }

    static int minBitFlips(int start,int goal) {
        int XORResult = start ^ goal;

        // Count no of set bits in XOR result
        int minFlips = 0;
        while (XORResult > 0) {
            if ((XORResult & 1) == 1) minFlips++;
            XORResult = XORResult >> 1;
        }

        return minFlips;
    }
}

// Stone Game

import java.util.Arrays;

public class LeetCode_877 {
    public static void main(String[] args) {
        int[] piles = {6,3,1,5,2,7,3,4};

        System.out.println(stoneGame(piles));
    }

    static boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int alicePts = 0;
        int bobPts = 0;

        for (int i = piles.length-1; i >= 0; i--) {
            if (i % 2 != 0) alicePts += piles[i];
            else bobPts += piles[i];
        }
        return alicePts > bobPts;
    }
}

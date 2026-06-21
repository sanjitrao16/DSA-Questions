// Maximum Points you can obtain from cards

import java.util.Arrays;

public class LeetCode_1423 {
    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 6;

        System.out.println(maxScore(cardPoints,k));
    }

    static int maxScore(int[] cardPoints,int k) {
        int n = cardPoints.length;
        if (n == k) return Arrays.stream(cardPoints).sum();

        int sum = 0;
        for (int i = 0;i<k;i++) {
            sum += cardPoints[i];
        }

        int fwd = k-1;
        int bck = n-1;
        int maxPoints = sum;

        for (int i = 0;i < k;i++) {
            sum -= cardPoints[fwd];
            fwd--;
            sum += cardPoints[bck];
            bck--;
            maxPoints = Math.max(maxPoints,sum);
        }

        return maxPoints;
    }
}

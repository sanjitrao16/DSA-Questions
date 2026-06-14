// Candy Distribution Problem

import java.util.Arrays;

public class LeetCode_135 {
    public static void main(String[] args) {
        int[] ratings = {2,2,0,1,3,4,6};
        System.out.println(candyOneArray(ratings));
    }

    static int candyOneArray(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy,1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1]+1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candy[i] = Math.max(candy[i],candy[i+1] + 1);
            }
        }

        // Calculating candy sum
        return Arrays.stream(candy).sum();
    }

    static int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftCandy = new int[n];
        int[] rightCandy = new int[n];

        Arrays.fill(leftCandy,1);
        Arrays.fill(rightCandy,1);

        // Forward traversal
        for (int i = 0; i < n-1; i++) {
            if (ratings[i] > ratings[i+1]) {
                leftCandy[i]++;
            } else if (ratings[i] < ratings[i+1]) {
                leftCandy[i+1] = leftCandy[i] + 1;
            }
        }

        for (int i = n-2;i >=0;i--) {
            if (ratings[i] > ratings[i+1]) {
                rightCandy[i] = rightCandy[i+1] + 1;
            } else if (ratings[i] < ratings[i+1]) {
                rightCandy[i+1]++;
            }
        }

        // Calculating leftCandy and rightCandy sum
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += leftCandy[i];
            rightSum += rightCandy[i];
        }

        return Math.max(leftSum,rightSum);
    }
}

// Sort the students by their Kth Score

import java.util.Arrays;

public class LeetCode_2545 {
    public static void main(String[] args) {
        int[][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k = 2;

        System.out.println(Arrays.deepToString(sortTheStudents(score,k)));
    }

    static int[][] sortTheStudents(int[][] score,int k) {
        for (int i = 0;i<score.length;i++) {
            int row = i;
            for (int j = i+1;j<score.length;j++) {
                if (score[j][k] > score[row][k]) row = j;
            }

            int[] temp = score[i];
            score[i] = score[row];
            score[row] = temp;
        }

        return score;
    }
}

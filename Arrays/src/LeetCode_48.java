// Rotate Image

// Given a matrix rotate it 90 degrees clockwise

import java.util.Arrays;

public class LeetCode_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);

        for (int[] i: matrix) {
            System.out.println(Arrays.toString(i));
        }
    }

    /*
    *
    * 1. Transpose the matrix
    * 2. Reverse each row
    *
    *  */

    static void rotate(int[][] matrix) {
        // Transpose of matrix
        for (int i = 0;i<matrix.length;i++) {
            for (int j = i;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int start;
        int end;

        // Reversing each row
        for (int i = 0;i<matrix.length;i++) {
            start = 0;
            end = matrix[i].length-1;

            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}

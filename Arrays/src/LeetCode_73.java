// Set Matrix Zeroes

// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.

import java.util.Arrays;

public class LeetCode_73 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroes(matrix);
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    static void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0;j<matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i =0;i<rows.length;i++) {
            for (int j = 0;j<cols.length;j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

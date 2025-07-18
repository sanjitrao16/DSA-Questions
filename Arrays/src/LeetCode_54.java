import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n-1, left = 0, right = m-1;

        while (top<=bottom && left<=right) {
            // Moving left to right
            for (int i = left;i<=right;i++) {
                result.add(matrix[top][i]);
            }

            top++;

            // Moving from top to bottom
            for (int i = top;i<=bottom;i++) {
                result.add(matrix[i][right]);
            }

            right--;

            // Moving from right to left
            if (top<=bottom) {
                for (int i = right;i>=left;i--) {
                    result.add(matrix[bottom][i]);
                }

                bottom--;
            }

            // Moving from bottom to top
            if (left<=right) {
                for (int i = bottom;i>=top;i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}

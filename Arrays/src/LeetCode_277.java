// Find the Celebrity

public class LeetCode_277 {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0},{0,1,0},{0,1,1}};
        System.out.println(celebrity(mat));
    }

    static int celebrity(int[][] mat) {
        int n = mat.length;

        int left = 0;
        int right = n-1;

        while (left < right) {
            if (mat[left][right] == 0) right--;
            else left++;
        }

        int candidate = left;

        // Verify : Check if the row of the candidate is 0s and column is 1s
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) return -1;
            }
        }

        return candidate;
    }
}

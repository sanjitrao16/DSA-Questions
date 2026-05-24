// Flood-Fill

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_733 {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        image = floodFill(image,1,1,2);

        printMatrix(image);
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("OUTPUT");
        for (int i = 0;i<matrix.length;i++) {
            System.out.print("[ ");
            for (int j = 0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("]");
        }
    }

    static int[][] floodFill(int[][] image,int sr,int sc,int color) {
        // Define a queue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int orgColor = image[sr][sc];

        if (orgColor == color) return image;

        int m = image.length;
        int n = image[0].length;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int r = pair.i;
            int c = pair.j;

            // Change colour
            image[r][c] = color;

            for (int i = 0;i<4;i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && image[newR][newC] == orgColor) {
                    q.add(new Pair(newR,newC));
                    image[newR][newC] = color;
                }
            }
        }

        return image;
    }
}

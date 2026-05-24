// Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

public class LeetCode_994 {
    public static void main(String[] args) {
        int[][] grid = {{1},{2}};
        System.out.println(orangesRotting(grid));
    }

    static int orangesRotting(int[][] grid) {
        // Define a queue
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int freshOrangeCount = 0;

        // Traverse the matrix once to find the rotten oranges
        for (int i = 0;i<grid.length;i++) {
            for (int j = 0;j<grid[i].length;j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
                else if (grid[i][j] == 1) {
                    freshOrangeCount++;
                }
            }
        }

        if (freshOrangeCount == 0) return 0;
        if (q.isEmpty()) return -1;
        int minutes = -1;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int i = 0;i<size;i++) {
                Pair pair = q.poll();
                // Make the oranges present in the adjacent (4-directionally) rotten
                int rowIdx = pair.i;
                int colIdx = pair.j;

                for (int j = 0;j< 4;j++) {
                    int newR = rowIdx + dr[j];
                    int newC = colIdx + dc[j];

                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        Pair newPair = new Pair(newR,newC);
                        q.add(newPair);
                        freshOrangeCount--;
                    }
                }
            }
        }

        return freshOrangeCount == 0 ? minutes:-1;
    }
}

class Pair {
    int i;
    int j;

    Pair(int i,int j) {
        this.i = i;
        this.j = j;
    }
}

// Also LeetCode - 542 : 01 Matrix

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int rowCord;
    int colCord;
    int steps;

    Node(int f,int s,int steps) {
        this.rowCord = f;
        this.colCord = s;
        this.steps = steps;
    }
}
public class GFG_Distance_Of_Nearest_1 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};

        System.out.println(nearest(grid));
    }

    static ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();

        for (int i = 0;i<n;i++) {
            dist.add(new ArrayList<>());
            for (int j = 0;j<m;j++) {
                dist.get(i).add(0);
            }
        }

        Queue<Node> q = new LinkedList<Node>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while (!q.isEmpty()) {
            Node val = q.poll();
            int row = val.rowCord;
            int col = val.colCord;
            int step = val.steps;

            dist.get(row).set(col,step);

            for (int i = 0;i < 4;i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new Node(nr,nc,step+1));
                }
            }
        }

        return dist;
    }
}

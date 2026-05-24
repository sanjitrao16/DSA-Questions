// Bipartite Graph

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_785 {
    public static void main(String[] args) {
        int[][] graph = {{1},{0,2,5},{1,3},{2,4,6},{3,5},{1,4},{3,7},{6}};
//        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};

//        System.out.println(isBipartiteBFS(graph));
        System.out.println(isBipartiteDFS(graph));
    }

    static boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        if (n == 1 || n == 2) return true;

        int[] coloured = new int[n];
        Arrays.fill(coloured,-1);

        Queue<Integer> q = new LinkedList<>();
        int[] colours = {0,1};

        for (int i = 0; i < n; i++) {
            if (coloured[i] == -1) {
                q.add(i);
                coloured[i] = colours[0];

                while (!q.isEmpty()) {
                    int val = q.poll();
                    int curColor = coloured[val];
                    // Go to its neighbours
                    for (int adj: graph[val]) {
                        // Check if it is not coloured/partitioned
                        if (coloured[adj] == -1) {
                            coloured[adj] = colours[curColor ^ 1];
                            q.add(adj);
                        } else {
                            if (coloured[adj] == curColor) return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    static boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        if (n == 1 || n == 2) return true;

        int[] coloured = new int[n];
        Arrays.fill(coloured,-1);

        int[] colours = {0,1};

        for (int i = 0; i < n; i++) {
            if (coloured[i] == -1) {
                coloured[i] = colours[0];
                if (!performDFS(i,coloured,colours,graph)) return false;
            }
        }

        return true;
    }

    static boolean performDFS(int s,int[] coloured,int[] colours,int[][] graph) {
        for (int adj: graph[s]) {
            if (coloured[adj] == -1) {
                coloured[adj] = colours[coloured[s] ^ 1];
                return performDFS(adj,coloured,colours,graph);
            } else {
                if (coloured[adj] == coloured[s]) return false;
            }
        }
        return true;
    }
}

// Number of Provinces
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_547 {
    public static void main(String[] args) {
//        int[][] isConnected = {{1,1,1,0,0},{1,1,0,1,0},{1,0,1,0,0},{0,1,0,1,0},{0,0,0,0,1}};
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    static int findCircleNum(int[][] isConnected) {
        // Find the number of connected components
        int connected = 0;
        int V = isConnected.length;
        boolean[] visited = new boolean[V+1];
        for (int i = 1;i <= V; i++) {
            if (!visited[i]) {
                connected++;
                bfsTraversal(isConnected,visited,i);
            }
        }
        return connected;
    }

    static void bfsTraversal(int[][] isConnected,boolean[] visited,int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int elem = q.poll();

            for (int i = 0;i<isConnected[elem-1].length;i++) {
                if (i+1 == elem) continue;
                else if (isConnected[elem-1][i] == 1 && !visited[i+1]) {
                    q.add(i+1);
                    visited[i+1] = true;
                }
            }
        }
    }
}

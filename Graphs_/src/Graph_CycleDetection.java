// Detecting cycle in undirected and directed graph (both BFS and DFS)

import java.util.LinkedList;
import java.util.Queue;

public class Graph_CycleDetection {
    public static void main(String[] args) {
//        int[][] adj = {{2},{1,3,5},{2,4,6},{3},{2},{3}};
//        int[][] adj = {{2,4},{1,3},{2,7},{1,5},{4,6,7},{5},{3,5}};
//        System.out.println(isCycleBFS(adj,7) == 1 ? "YES":"NO");
//        System.out.println(isCycleDFS(adj,7) == 1 ? "YES":"NO");

        int[][] adj = {{1},{2},{3,6},{4},{5},{},{4},{1,8},{9},{7}};
        System.out.println(isCycleDirectedDFS(adj) == 1 ? "YES":"NO");
    }

    static int isCycleDirectedDFS(int[][] adj) {
        int V = adj.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V;i++) {
            if (!visited[i]) {
                if (checkDirectedDFS(i,visited,pathVisited,adj)) return 1;
            }
        }

        return 0;
    }

    static boolean checkDirectedDFS(int s,boolean[] visited,boolean[] pathVisited,int[][] adj) {
        visited[s] = true;
        pathVisited[s] = true;

        for (int n: adj[s]) {
            if (!visited[n] && checkDirectedDFS(n,visited,pathVisited,adj)) {
                return true;
            }

            else if (pathVisited[n]) return true;
        }

        pathVisited[s] = false;
        return false;
    }

    static int isCycleBFS(int[][] adj,int V) {
        // Define a queue
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        // Define a visited array
        boolean[] visited = new boolean[V+1];

        while (!q.isEmpty()) {
            int v = q.poll();
            // Check if it is visited
            if (visited[v]) return 1;
            visited[v] = true;

            // Add neighbours to the queue only if not visited
            for (int i = 0;i<adj[v-1].length;i++) {
                if (!visited[adj[v-1][i]]) q.add(adj[v-1][i]);
            }
        }

        return 0;
    }

    static int isCycleDFS(int[][] adj,int V) {
        boolean[] visited = new boolean[V+1];
        // starting node = 1

        for (int v = 0;v<V;v++) {
            if (checkDFS(v,adj,visited,-1)) {
                return 1;
            }
        }
        return 0;
    }

    static boolean checkDFS(int v,int[][] adj,boolean[] visited,int parent) {
        visited[v] = true;

        for (int n: adj[v]) {
            if (!visited[n]) {
                if (checkDFS(n,adj,visited,v)) return true;
            }

            else if (n != parent)
                return true;
        }
        return false;
    }
}

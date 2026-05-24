// Shortest Distance in a directed acyclic graph
// using topological sort

import java.util.Arrays;
import java.util.Stack;

public class Shortest_Distance_DAG {
    public static void main(String[] args) {
        int[][][] adj = {
                {{1,2}},
                {{3,1}},
                {{3,3}},
                {{}},
                {{0,3},{2,1}},
                {{4,1}},
                {{4,2},{5,3}}
        };

        int[] dist = shortestDistanceDAG(adj,6);
        System.out.println(Arrays.toString(dist));
    }

    static int[] shortestDistanceDAG(int[][][] adj,int src) {
        int V = adj.length;

        // Step - 1: Perform a Topological Sort
        Stack<Integer> s = performTopologicalSort(V,adj);

        // Step - 2: Take out nodes from stacks and relax the edges
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        while (!s.isEmpty()) {
            int node = s.pop();
            for (int[] pair: adj[node]) {
                if (pair.length == 0) continue;
                int n = pair[0];
                int tempDist = dist[node] + pair[1];
                if (tempDist < dist[n]) {
                    dist[n] = tempDist;
                }
            }
        }

        return dist;
    }

    static Stack<Integer> performTopologicalSort(int V,int[][][] adj) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalDFS(i,s,visited,adj);
            }
        }
        return s;
    }

    static void topologicalDFS(int node,Stack<Integer> s,boolean[] visited,int[][][] adj) {
        visited[node] = true;

        for (int[] pair: adj[node]) {
            if (pair.length == 0) continue;
            int neighbour = pair[0];
            if (!visited[neighbour]) {
                topologicalDFS(neighbour,s,visited,adj);
            }
        }

        s.add(node);
    }
}

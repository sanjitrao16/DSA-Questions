// Shortest Distance in Undirected graph with unit weights
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class DistancePair {
    int node;
    int distance;

    DistancePair(int node,int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Shortest_Distance_Unit_Weights {
    public static void main(String[] args) {
//        int[][] adj = {{1,3},{0,2,3},{1,6},{0,1,4},{3,5},{4,6},{2,5,7,8},{6,8},{6,7}};
        int[][] adj = {{3},{3},{},{0,1}};

        int[] result = shortestDistanceUnitWeight(adj,3);
        System.out.println(Arrays.toString(result));
    }

    static int[] shortestDistanceUnitWeight(int[][] adj,int source) {
        int V = adj.length;
        int[] dist = new int[V];
        Queue<DistancePair> q = new LinkedList<>();

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        q.add(new DistancePair(source,dist[source]));

        while (!q.isEmpty()) {
            DistancePair pair = q.poll();
            for (int n: adj[pair.node]) {
                if ((pair.distance + 1 < dist[n])) {
                    dist[n] = pair.distance + 1;
                    q.add(new DistancePair(n,dist[n]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}

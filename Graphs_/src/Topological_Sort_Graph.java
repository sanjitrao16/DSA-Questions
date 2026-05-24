import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Topological_Sort_Graph {
    public static void main(String[] args) {
        int[][] adj = {{},{},{3},{1},{0,1},{0,2}};

//        System.out.println(Arrays.toString(topologicalSort(adj)));
        System.out.println(Arrays.toString(kahnAlgorithm(adj)));
    }

    static int[] kahnAlgorithm(int[][] adj) {
        int V = adj.length;

        int[] inDegree = findIndegree(V,adj);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0;i < V;i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[V];
        int index = 0;
        while (!q.isEmpty()) {
            int val = q.poll();
            result[index++] = val;

            for (int n: adj[val]) {
                inDegree[n] -= 1;
                if (inDegree[n] == 0) q.add(n);
            }

        }

        return result;
    }

    static int[] findIndegree(int V,int[][] adj) {
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int j: adj[i]) {
                inDegree[j] += 1;
            }
        }

        return inDegree;
    }

    static int[] topologicalSort(int[][] adj) {
        int V = adj.length;
        boolean[] visited = new boolean[V];
        int[] result = new int[V];
        Stack<Integer> order = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsLook(i,visited,adj,order);
            }
        }

        int index = 0;
        while (!order.isEmpty()) {
            result[index++] = order.pop();
        }

        return result;
    }

    static void dfsLook(int s,boolean[] visited,int[][] adj,Stack<Integer> order) {
        visited[s] = true;

        for (int n: adj[s]) {
            if (!visited[n]) {
                dfsLook(n,visited,adj,order);
            }
        }

        order.add(s);
    }
}

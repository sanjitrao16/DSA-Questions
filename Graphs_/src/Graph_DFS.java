import java.util.ArrayList;
import java.util.Stack;

public class Graph_DFS {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{0,2},{0,1,3,4},{2},{2}};

        StoreGraph sg = new StoreGraph();
        ArrayList<ArrayList<Integer>> adj = sg.createList(matrix,5);

        ArrayList<Integer> dfsTraversal = graphDFS(adj);
        System.out.println(dfsTraversal);
    }

    public static ArrayList<Integer> graphDFS(ArrayList<ArrayList<Integer>> adj) {
        // Initialize a visited array of size V
        int V = adj.size();
        int[] visited = new int[V];

        // Traversed Array
        ArrayList<Integer> traversed = new ArrayList<>();

        dfsRecursion(adj,visited,0,traversed);

        return traversed;
    }

    static void dfsRecursion(ArrayList<ArrayList<Integer>> adj,int[] visited,int s,ArrayList<Integer> traversed) {
        visited[s] = 1;
        traversed.add(s);

        for (int i = 0;i<adj.get(s).size();i++) {
            int node = adj.get(s).get(i);
            if (visited[node] == 0) {
                dfsRecursion(adj,visited,node,traversed);
            }
        }
    }
}

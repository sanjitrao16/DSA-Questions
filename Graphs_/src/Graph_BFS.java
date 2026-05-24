import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Graph_BFS {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{0,2},{0,1,3,4},{2},{2}};

        StoreGraph sg = new StoreGraph();
        ArrayList<ArrayList<Integer>> adj = sg.createList(matrix,5);

        ArrayList<Integer> bfsTraversal = graphBFS(adj);
        System.out.println(bfsTraversal);
    }

    public static ArrayList<Integer> graphBFS(ArrayList<ArrayList<Integer>> adj) {
        // Initialize a visited array of size V (0-indexed)
        int V = adj.size();
        int[] visited = new int[V]; // [1,1,1,1,1]

        // Initialize a queue with the starting index enqueued (starting index = 0)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        // Traversed Array
        ArrayList<Integer> traversed = new ArrayList<>();

        int elem;
        while (!queue.isEmpty()) {
            elem = queue.poll();
            visited[elem] = 1;
            traversed.add(elem);

            for (int i = 0;i<adj.get(elem).size();i++) {
                int node = adj.get(elem).get(i);
                if (visited[node] == 0) {
                    queue.add(node);
                    visited[node] = 1;
                }
            }
        }

        return traversed;
    }
}

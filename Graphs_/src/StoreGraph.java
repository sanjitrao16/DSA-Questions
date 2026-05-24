import java.util.ArrayList;

public class StoreGraph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    private void initList(int[][] matrix) {
        adj = new ArrayList<>();
        for (int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
        }
    }

    // mat = {{2,3,1},{0},{0,4},{0},{2}};
    // adj = {{2,3,1},{0},{0,4},{0},{2}}

    private void addEdges(int[][] mat) {
        for (int i = 0;i < mat.length;i++) {
            for (int j = 0;j < mat[i].length; j++) {
                adj.get(i).add(mat[i][j]);
            }
        }
    }

    private void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0;i<adj.size();i++) {
            System.out.println("Vertex "+i+": ");
            for (int j = 0;j<adj.get(i).size();j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Integer>> createList(int[][] mat,int v) {
        V = v;
        initList(mat);
        addEdges(mat);

        // printGraph();

        return adj;
    }
}

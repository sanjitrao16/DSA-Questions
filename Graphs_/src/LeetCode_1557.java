// Minimum Number of vertices to reach all nodes

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1557 {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(List.of(0,1)));
//        edges.add(new ArrayList<>(List.of(0,2)));
//        edges.add(new ArrayList<>(List.of(2,5)));
//        edges.add(new ArrayList<>(List.of(3,4)));
//        edges.add(new ArrayList<>(List.of(4,2)));

        List<Integer> result = findSmallestSetOfVertices(n,edges);
        System.out.println(result);
    }

    static List<Integer> findSmallestSetOfVertices(int n,List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[n];

        for (List<Integer> edge: edges) {
            inDegree[edge.get(1)]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) result.add(i);
        }
        return result;
    }
}

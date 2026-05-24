// Course Schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_207 {
    public static void main(String[] args) {
        int n = 6;
        int[][] prerequisites = {{2,1},{3,1},{1,0},{3,4},{1,5}};
//        int[][] prerequisites = {{0,10},{3,18},{6,11},{11,14},{13,1},{15,1},{17,4}};
//        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
//        int[][] prerequisites = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
//        int[][] prerequisites = {{1,0},{0,1}};

        System.out.println(canFinish(n,prerequisites));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = createAdjacencyList(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, pathVisited)) return false;
            }
        }
        return true;
    }

    static boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, pathVisited)) return true;
            } else if (pathVisited[neighbor]) {
                // Found a node that is currently in the recursion stack -> Cycle!
                return true;
            }
        }

        // Backtrack: remove from path stack before returning
        pathVisited[node] = false;
        return false;
    }

    static ArrayList<ArrayList<Integer>> createAdjacencyList(int n,int[][] list) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < list.length; i++) {
            adj.get(list[i][0]).add(list[i][1]);
        }

        return adj;
    }
}

// Keys and Rooms

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(new ArrayList<>(List.of()));
        rooms.add(new ArrayList<>(List.of(2,0,3)));
        rooms.add(new ArrayList<>(List.of(1,3,5)));
        rooms.add(new ArrayList<>(List.of(4)));
        rooms.add(new ArrayList<>(List.of(0,2)));
        rooms.add(new ArrayList<>(List.of(4,5)));

        System.out.println(canVisitAllRooms(rooms));
    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() > 1 && rooms.getFirst().isEmpty()) return false;

        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int key: rooms.getFirst()) {
            q.add(key);
        }
        visited[0] = true;

        while (!q.isEmpty()) {
            int key = q.poll();

            if (!visited[key]) {
                visited[key] = true;

                for (int k: rooms.get(key)) {
                    if (!visited[k]) q.add(k);
                }
            }
        }

        for (int i = 0;i<rooms.size();i++) {
            if (!visited[i]) return false;
        }

        return true;
    }
}

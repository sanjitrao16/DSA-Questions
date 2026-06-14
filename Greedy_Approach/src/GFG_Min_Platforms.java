// Minimum Number of Platforms required

import java.util.Arrays;
import java.util.PriorityQueue;

class TrainTiming {
    int arrTime;
    int deptTime;

    public TrainTiming(int at,int dt) {
        this.arrTime = at;
        this.deptTime = dt;
    }
}

public class GFG_Min_Platforms {
    public static void main(String[] args) {
        int[] arr = {1000, 935, 1100};
        int[] dept = {1200, 1240, 1130};

        System.out.println(minPlatforms(arr,dept));
    }

    static int minPlatforms(int[] arr,int[] dept) {
        // Store it in a different object
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        TrainTiming[] schedule = new TrainTiming[n];

        for (int i = 0; i < n; i++) {
            schedule[i] = new TrainTiming(arr[i],dept[i]);
        }

        Arrays.sort(schedule,(s1, s2) -> {
            int arrTime = Integer.compare(s1.arrTime, s2.arrTime);
            int deptTime = Integer.compare(s1.deptTime,s2.deptTime);

            return (arrTime == 0) ? deptTime : arrTime;
        });

        PriorityQueue<Integer> deptOrder = new PriorityQueue<>();
        int minPlatform = 1;
        deptOrder.add(schedule[0].deptTime);

        for (int i = 1; i < n; i++) {
            int arrivalTime = schedule[i].arrTime;
            if (deptOrder.isEmpty()) {
                deptOrder.add(schedule[i].deptTime);
                continue;
            }
            int deptTime = deptOrder.peek();

            if (arrivalTime <= deptTime) {
                minPlatform++;
                deptOrder.add(schedule[i].deptTime);
            } else if (arrivalTime > deptTime) {
                deptOrder.poll();
                deptOrder.add(schedule[i].deptTime);
            }
        }

        return minPlatform;
    }
}

// Activity Selection Problem

import java.util.Arrays;

class Activity {
    int start;
    int end;

    public Activity(int start,int end) {
        this.start = start;
        this.end = end;
    }
}

public class Activity_Selection_Problem {
    public static void main(String[] args) {
        int[] start = {1,3,2,5};
        int[] end = {2,4,3,6};

        System.out.println(activitySelection(start,end));
    }

    static int activitySelection(int[] start,int[] end) {
        int n = start.length;

        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i],end[i]);
        }

        Arrays.sort(activities,(a1,a2) -> {
            int endCompare = Integer.compare(a1.end,a2.end);
            int startCompare = Integer.compare(a1.start,a2.start);

            return (endCompare == 0) ? startCompare: endCompare;
        });

        int endTime = activities[0].end;
        int activityCount = 1;

        for (int i = 1;i<n;i++) {
            int startTime = activities[i].start;
            if (startTime > endTime) {
                activityCount++;
                endTime = activities[i].end;
            }
        }

        return activityCount;
    }
}

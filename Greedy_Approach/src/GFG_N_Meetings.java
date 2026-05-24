// N meetings in one room

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GFG_N_Meetings {
    public static void main(String[] args) {
        int[] s = {1,3,0,5,8,5};
        int[] e = {2,4,5,7,9,9};

        System.out.println(maxMeetings(s,e));
    }

    static int maxMeetings(int[] start,int[] end) {
        List<int[]> meetings = new ArrayList<>();

        for (int i =0;i<start.length;i++) {
            meetings.add(new int[] {end[i],start[i],i+1});
        }

        meetings.sort(Comparator.comparingInt(a->a[0]));
        int lastEnd = -1;
        int meetingCount = 0;

        for (int[] m:meetings) {
            if (m[1] > lastEnd) {
                meetingCount++;
                lastEnd = m[0];
            }
        }

        return meetingCount;
    }
}
